package jvm;

/**
 * @author ZHANGWJ
 * @date 2020/7/29 20:06
 */
public class JavaVMStackSOF {

    private static int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void test() {
        long X1,X1X1,X1X1X1,X1X1X1X1,X1X1X1X1X1,X1X1X1X1X1X1,X1X1X1X1X1X1X1,X1X1X1X1X1X1X1X1,X1X1X1X1X1X1X1X1X1 = 0;
        long x2,x2x2,x2x2x2,x2x2x2x2,x2x2x2x2x2,x2x2x2x2x2x2,x2x2x2x2x2x2x2,x2x2x2x2x2x2x2x2,x2x2x2x2x2x2x2x2x2 = 0;
        long x3,x3x3,X3x2x2,x2X3X3X3,X3X3X3X3X3,X3X3X3X3X3X3,X3X3X3X3X3X3X3,X3X3X3X3X3X3X3X3,X3X3X3X3X3X3X3X3X3 = 0;
        long X4,X4X4,X4X4X4,X4X4X4X4,X4X4X4X4X4,X4X4X4X4X4X4,X4X4X4X4X4X4X4,X4X4X4X4X4X4X4X4,X4X4X4X4X4X4X4X4X4 = 0;
        long X5,X5X5,X5X5X5,X5X5X5X5,X5X5X5X5X5,X5X5X5X5X5X5,X5X5X5X5X5X5X5,X5X5X5X5X5X5X5X5,X5X5X5X5X5X5X5X5X5 = 0;
        long X6,X6X6,X6X6X6,X6X6X6X6,X6X6X6X6X6,X6X6X6X6X6X6,X6X6X6X6X6X6X6,X6X6X6X6X6X6X6X6,X6X6X6X6X6X6X6X6X6 = 0;
        long X7,X7X7,X7X7X7,X7X7X7X7,X7X7X7X7X7,X7X7X7X7X7X7,X7X7X7X7X7X7X7,X7X7X7X7X7X7X7X7,X7X7X7X7X7X7X7X7X7 = 0;
        long X8,X8X8,X8X8X8,X8X8X8X8,X8X8X8X8X8,X8X8X8X8X8X8,X8X8X8X8X8X8X8,X8X8X8X8X8X8X8X8,X8X8X8X8X8X8X8X8X8 = 0;
        long X9,X9X9,X9X9X9,X9X9X9X9,X9X9X9X9X9,X9X9X9X9X9X9,X9X9X9X9X9X9X9,X9X9X9X9X9X9X9X9,X9X9X9X9X9X9X9X9X9 = 0;
        long Y0,Y0Y0,Y0Y0Y0,Y0Y0Y0Y0,Y0Y0Y0Y0Y0,Y0Y0Y0Y0Y0Y0,Y0Y0Y0Y0Y0Y0Y0,Y0Y0Y0Y0Y0Y0Y0Y0,Y0Y0Y0Y0Y0Y0Y0Y0Y0 = 0;
        long Y1,Y1Y1,Y1Y1Y1,Y1Y1Y1Y1,Y1Y1Y1Y1Y1,Y1Y1Y1Y1Y1Y1,Y1Y1Y1Y1Y1Y1Y1,Y1Y1Y1Y1Y1Y1Y1Y1,Y1Y1Y1Y1Y1Y1Y1Y1Y1 = 0;
        long Y2,Y2Y2,Y2Y2Y2,Y2Y2Y2Y2,Y2Y2Y2Y2Y2,Y2Y2Y2Y2Y2Y2,Y2Y2Y2Y2Y2Y2Y2,Y2Y2Y2Y2Y2Y2Y2Y2,Y2Y2Y2Y2Y2Y2Y2Y2Y2 = 0;
        long Y3,Y3Y3,Y3Y2Y2,Y2Y3Y3Y3,Y3Y3Y3Y3Y3,Y3Y3Y3Y3Y3Y3,Y3Y3Y3Y3Y3Y3Y3,Y3Y3Y3Y3Y3Y3Y3Y3,Y3Y3Y3Y3Y3Y3Y3Y3Y3 = 0;
        long Y4,Y4Y4,Y4Y4Y4,Y4Y4Y4Y4,Y4Y4Y4Y4Y4,Y4Y4Y4Y4Y4Y4,Y4Y4Y4Y4Y4Y4Y4,Y4Y4Y4Y4Y4Y4Y4Y4,Y4Y4Y4Y4Y4Y4Y4Y4Y4 = 0;
        long Y5,Y5Y5,Y5Y5Y5,Y5Y5Y5Y5,Y5Y5Y5Y5Y5,Y5Y5Y5Y5Y5Y5,Y5Y5Y5Y5Y5Y5Y5,Y5Y5Y5Y5Y5Y5Y5Y5,Y5Y5Y5Y5Y5Y5Y5Y5Y5 = 0;
        long Y6,Y6Y6,Y6Y6Y6,Y6Y6Y6Y6,Y6Y6Y6Y6Y6,Y6Y6Y6Y6Y6Y6,Y6Y6Y6Y6Y6Y6Y6,Y6Y6Y6Y6Y6Y6Y6Y6,Y6Y6Y6Y6Y6Y6Y6Y6Y6 = 0;
        long Y7,Y7Y7,Y7Y7Y7,Y7Y7Y7Y7,Y7Y7Y7Y7Y7,Y7Y7Y7Y7Y7Y7,Y7Y7Y7Y7Y7Y7Y7,Y7Y7Y7Y7Y7Y7Y7Y7,Y7Y7Y7Y7Y7Y7Y7Y7Y7 = 0;
        long Y8,Y8Y8,Y8Y8Y8,Y8Y8Y8Y8,Y8Y8Y8Y8Y8,Y8Y8Y8Y8Y8Y8,Y8Y8Y8Y8Y8Y8Y8,Y8Y8Y8Y8Y8Y8Y8Y8,Y8Y8Y8Y8Y8Y8Y8Y8Y8 = 0;
        long Y9,Y9Y9,Y9Y9Y9,Y9Y9Y9Y9,Y9Y9Y9Y9Y9,Y9Y9Y9Y9Y9Y9,Y9Y9Y9Y9Y9Y9Y9,Y9Y9Y9Y9Y9Y9Y9Y9,Y9Y9Y9Y9Y9Y9Y9Y9Y9 = 0;
        long Z0,Z0Z0,Z0Z0Z0,Z0Z0Z0Z0,Z0Z0Z0Z0Z0,Z0Z0Z0Z0Z0Z0,Z0Z0Z0Z0Z0Z0Z0,Z0Z0Z0Z0Z0Z0Z0Z0,Z0Z0Z0Z0Z0Z0Z0Z0Z0 = 0;
        long Z1,Z1Z1,Z1Z1Z1,Z1Z1Z1Z1,Z1Z1Z1Z1Z1,Z1Z1Z1Z1Z1Z1,Z1Z1Z1Z1Z1Z1Z1,Z1Z1Z1Z1Z1Z1Z1Z1,Z1Z1Z1Z1Z1Z1Z1Z1Z1 = 0;
        long Z2,Z2Z2,Z2Z2Z2,Z2Z2Z2Z2,Z2Z2Z2Z2Z2,Z2Z2Z2Z2Z2Z2,Z2Z2Z2Z2Z2Z2Z2,Z2Z2Z2Z2Z2Z2Z2Z2,Z2Z2Z2Z2Z2Z2Z2Z2Z2 = 0;
        long Z3,Z3Z3,Z3Z2Z2,Z2Z3Z3Z3,Z3Z3Z3Z3Z3,Z3Z3Z3Z3Z3Z3,Z3Z3Z3Z3Z3Z3Z3,Z3Z3Z3Z3Z3Z3Z3Z3,Z3Z3Z3Z3Z3Z3Z3Z3Z3 = 0;
        long Z4,Z4Z4,Z4Z4Z4,Z4Z4Z4Z4,Z4Z4Z4Z4Z4,Z4Z4Z4Z4Z4Z4,Z4Z4Z4Z4Z4Z4Z4,Z4Z4Z4Z4Z4Z4Z4Z4,Z4Z4Z4Z4Z4Z4Z4Z4Z4 = 0;
        long Z5,Z5Z5,Z5Z5Z5,Z5Z5Z5Z5,Z5Z5Z5Z5Z5,Z5Z5Z5Z5Z5Z5,Z5Z5Z5Z5Z5Z5Z5,Z5Z5Z5Z5Z5Z5Z5Z5,Z5Z5Z5Z5Z5Z5Z5Z5Z5 = 0;
        long Z6,Z6Z6,Z6Z6Z6,Z6Z6Z6Z6,Z6Z6Z6Z6Z6,Z6Z6Z6Z6Z6Z6,Z6Z6Z6Z6Z6Z6Z6,Z6Z6Z6Z6Z6Z6Z6Z6,Z6Z6Z6Z6Z6Z6Z6Z6Z6 = 0;
        long Z7,Z7Z7,Z7Z7Z7,Z7Z7Z7Z7,Z7Z7Z7Z7Z7,Z7Z7Z7Z7Z7Z7,Z7Z7Z7Z7Z7Z7Z7,Z7Z7Z7Z7Z7Z7Z7Z7,Z7Z7Z7Z7Z7Z7Z7Z7Z7 = 0;
        long Z8,Z8Z8,Z8Z8Z8,Z8Z8Z8Z8,Z8Z8Z8Z8Z8,Z8Z8Z8Z8Z8Z8,Z8Z8Z8Z8Z8Z8Z8,Z8Z8Z8Z8Z8Z8Z8Z8,Z8Z8Z8Z8Z8Z8Z8Z8Z8 = 0;
        long Z9,Z9Z9,Z9Z9Z9,Z9Z9Z9Z9,Z9Z9Z9Z9Z9,Z9Z9Z9Z9Z9Z9,Z9Z9Z9Z9Z9Z9Z9,Z9Z9Z9Z9Z9Z9Z9Z9,Z9Z9Z9Z9Z9Z9Z9Z9Z9 = 0;
        long X0,X0X0,X0X0X0,X0X0X0X0,X0X0X0X0X0,X0X0X0X0X0X0,X0X0X0X0X0X0X0,X0X0X0X0X0X0X0X0,X0X0X0X0X0X0X0X0X0 = 0;

        stackLength++;

        test();
    }

    /*//-Xss128K
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }*/

    /*public static void main(String[] args) {
        try {
            test();
        } catch (Error e) {
            System.out.println("stack length: " + stackLength);
            throw e;
        }
    }*/

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.run();
        }
    }

    //-XSS2M 请在32位系统下运行
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        oom.stackLeakByThread();
    }

}
