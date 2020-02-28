package mq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BrokerServer implements Runnable{

    public static int SERVICE_PROT = 9999;

    private final Socket socket;

    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            while (true) {
                String str = in.readLine();
                if (null == str) {
                    continue;
                }
                System.out.println("接收到原始数据: " + str);
                //CONSUME表示要消费一条消息
                if (str.equals("CONSUME")) {
                    //从消息队列中消费一条消息
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                } else {
                    //其他情况都表示生产消息放到消息队列中
                    Broker.product(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(SERVICE_PROT);
        while (true) {
            BrokerServer brokerServer = new BrokerServer(server.accept());
            new Thread(brokerServer).start();
        }
    }
}
