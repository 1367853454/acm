package zaqizaba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2020/2/7 22:44
 */
public class OOMDemoMemLeak {
    private static final int _1KB = 1024 ;
    private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor.DiscardOldestPolicy());

    public static class CardInfo {
        BigDecimal bigDecimal = new BigDecimal(0.0);
        String name = "SimonnnnnZ";
        int age = 20;
        byte[] arr = new byte[_1KB];

        public void m() {}
    }

    public static void main(String[] args) throws Exception {
        for (; ; ) {
            modal();
            Thread.sleep(100);
        }
    }

    public static void modal() {
        List<CardInfo> cardInfos = getCardInfos();
        cardInfos.forEach(e ->{
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{ e.m(); },2,3, TimeUnit.SECONDS);
        });

    }

    public static List<CardInfo> getCardInfos() {
        List<CardInfo> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new CardInfo());
        }
        return list;
    }


}
