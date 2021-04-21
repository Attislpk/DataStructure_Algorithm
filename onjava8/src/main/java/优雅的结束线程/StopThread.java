package 优雅的结束线程;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private volatile static boolean flag = false;
    public static void main(String[] args) {

        //此处的lambda表达式实际上是一个匿名内部类，是函数式接口Runnable的实现
        Thread t = new Thread(()->{
            int i = 0;
            while (!flag) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i++);
            }
        });
        System.out.println(flag + "thread begin");
        t.start();
        //主线程睡2s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(flag);
    }
}
