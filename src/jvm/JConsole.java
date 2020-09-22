package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHANGWJ
 * @date 2020/8/7 11:29
 */
public class JConsole {

    static class OOMObject {
        //64k
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fillHeap(int num) throws InterruptedException {

        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //稍作延时 使得监控曲线更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    /**
     * VM 参数
     * -Xms100M -Xmx100M -XX:+UseSerialGC
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
