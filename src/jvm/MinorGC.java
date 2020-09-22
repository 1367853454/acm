package jvm;

/**
 * @author ZHANGWJ
 * @date 2020/8/2 14:18
 */
public class MinorGC {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * java堆为20M 不可扩展 新生代10M 老年代10M Eden区和Survivor 8 : 1 : 1
     *  allocation4 出现一次Minor GC
     *  allocation4 需要4M 而Eden已被占用6M 剩余空间不足 Minor GC
     *  但此时又有三个2M的对象无法全部放入Survivor(1M)
     *  通过分配担保提前转移至老年代
     *
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现一次 minor GC
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * VM参数 超过3M的就会直接写入老年代
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[]  allocation;
        //直接分配至老年代
        allocation = new byte[4 * _1MB];
    }

    /**
     * VM参数
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1 //年龄 1--15不同
     * -XX:+PrintTenuringDistribution
     *
     * 长期存活的对象将进入老年代
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        //什么时候进入来年代决定于 XX: MaxTenuringThreshold设置
        allocation1 = new byte[_1MB /4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * VM参数
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:-HandlePromotionFailure
     *
     * 老年代空间分配担保
     */
    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3,
                allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        //testAllocation();
        //testPretenureSizeThreshold();
        //testTenuringThreshold();
        testHandlePromotion();
    }

}
