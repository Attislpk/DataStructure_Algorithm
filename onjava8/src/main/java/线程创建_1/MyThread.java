package 线程创建_1;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("继承thread，重写run方法");
    }
}
