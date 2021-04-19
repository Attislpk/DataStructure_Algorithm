package 线程创建_1;

import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LambdaDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建线程方式1:匿名内部类");
            }
        }).start();

        MyRunnable my = new MyRunnable();
        Thread t = new Thread(my);
        t.start();

        new Thread(()->{
            System.out.println("创建线程方式3：lambda表达式");
        }).start();

        MyCallable mc = new MyCallable();
        FutureTask ft = new FutureTask(mc);
        Thread t2 = new Thread(ft);
        t2.start();
        System.out.println(ft.get());

        MyThread mt = new MyThread();
        mt.start();

        Runnable r2 = ()->{};
        r2.run();

        Comparator<Integer> comparator = (o1, o2) -> {
            return o2.compareTo(o1);
        };
        comparator.compare(12,13);
    }
}
