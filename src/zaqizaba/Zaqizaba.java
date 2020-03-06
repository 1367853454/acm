package zaqizaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Zaqizaba {

    private final static int MAX_SIZE = 3;

    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("----");
        hh();
        System.out.println("---");

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.printf(val + ","));
        System.out.println("---");

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

        System.out.println(map.containsKey(9));
        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        System.out.println(map.containsKey(23));
        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);

        System.out.println("---");
        System.out.println(map);
        System.out.println("---");
        map.forEach((id, val) -> System.out.printf(val + ","));

        Map<String,String> stringStringMap = new HashMap<>();
        stringStringMap.put("kk","vv");
        stringStringMap.put("k","v");
        stringStringMap.put("v","k");
        stringStringMap.put("vv","kk");
        System.out.println("---");
        stringStringMap.computeIfPresent("k",(k,v) -> null);
        stringStringMap.computeIfAbsent("k", num -> "val");
        System.out.println(stringStringMap);
    }

    public static void hh() {
        System.out.println("haha");
    }
}
