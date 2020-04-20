package com.company.bingfabiancheng;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/*public class TestUnsafe {

    static final Unsafe unsafe = Unsafe.getUnsafe();
    //记录变量state在类TestUnsafe中的偏移量
    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafe testUnsafe = new TestUnsafe();
        Boolean success = unsafe.compareAndSwapInt(testUnsafe,stateOffset,0,1);
        System.out.println(success);
    }

}*/

/**
 * 无法从正规渠道访问 JDK开发组想让开发人员在rt.jar包里面的核心类中使用Unsafe功能
 * 但是可以通过反射机制来获取运行时类的属性和方法
 */
public class TestUnsafe {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);

            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {

        TestUnsafe testUnsafe = new TestUnsafe();
        Boolean success = unsafe.compareAndSwapInt(testUnsafe,stateOffset,0, 1);
        System.out.println(success);

    }

}
