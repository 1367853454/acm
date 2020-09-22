package jvm;

/**
 * @author ZHANGWJ
 * @date 2020/8/2 9:59
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :) ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    //-XX:+PrintGC 查看GC基本信息
    //-XX:+PrintHeapAtGC 查看GC前后的堆、方法区可用容量变化
    public static void main(String[] args) throws Throwable{

        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        saveSelf();

        //自救失败 因为finalize()方法只会被执行一次
        saveSelf();

    }

    public static void saveSelf() throws Throwable{
        SAVE_HOOK = null;
        System.gc();
        //finalize() 方法优先级太低 暂停等待
        Thread.sleep(600);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }

}
