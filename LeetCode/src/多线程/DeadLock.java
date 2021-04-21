package 多线程;

import java.util.concurrent.TimeUnit;

class DeadLock {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                try {
                    System.out.println("get lockA");
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("trying to get lockB");
                synchronized (lockB) {
                    System.out.println("get lockB");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (lockB) {

                System.out.println("get lockB");
                System.out.println("trying to get lockA");

                synchronized (lockA) {
                    System.out.println("get lockA");
                }
            }
        }).start();
    }
}


