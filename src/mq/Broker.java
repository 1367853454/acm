package mq;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {

    //消息队列存储的最大消息数
    private final static int MAX_SIZE = 3;

    //保存消息数据的容器
    //数组实现的线程安全的有界的阻塞队列。FIFO
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    //生产消息
    public static void product(String msg) {
        //将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息: " + msg + ", 当前暂存的消息数量是:" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息！");
        }
        System.out.println("-------------------------------------------------------");
    }

    //消费消息
    public static String consume() {
        //获取并移除此队列的头，如果此队列为空，则返回 null。
        String msg = messageQueue.poll();
        if (null != msg) {
            //消费条件满足情况，从消息容器中去取出一条消息
            System.out.println("已经消费消息: " + msg + ", 当前暂存的消息数量是: " + messageQueue.size());
        } else {
            System.out.println("消费处理中心没有消息可供消费！");
        }
        System.out.println("--------------------------------------------------------");

        return msg;
    }

}
