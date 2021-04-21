package 优雅的结束线程;

import java.util.concurrent.TimeUnit;

public class StopThread2 {
    public static void main(String[] args) {

        Thread thread = new Thread (()->{
            while (true) {
                //让线程休眠10s，在休眠过程中采用interrupt()唤醒
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    //打断休眠之后执行的逻辑
                    System.out.println("我被打断了, 在这里执行退出线程的代码");
                    //在InterruptedException异常被捕获之后，中断标志位会被重置
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //将打断标志位置为1
        thread.interrupt();

        //查看线程的打断标志位是否是1，返回true 或 false
        System.out.println(thread.isInterrupted());  //true

        //查看当前线程(主线程)的中断标志位，并且清除标志位
        System.out.println(Thread.interrupted());  //false
    }
}
