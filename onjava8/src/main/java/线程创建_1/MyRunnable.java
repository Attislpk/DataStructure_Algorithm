package 线程创建_1;

public class MyRunnable implements  Runnable{
    @Override
    public void run() {
        System.out.println("创建线程方式2：实现runnable接口");
    }
}
