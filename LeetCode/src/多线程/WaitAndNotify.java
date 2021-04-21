package 多线程;

import javax.naming.spi.ResolveResult;
import java.util.concurrent.TimeUnit;

//顺序打印两个线程，ABABABABAB...... 使用wait和notify()
public class WaitAndNotify {

    public static void main(String[] args) {
        Resource resource = new Resource();
        //使用lambda表达式实现匿名内部类
        new Thread(()->{resource.print();},"A").start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //resource.print()可以使用方法引用替换, 方法引用不就是调用实例/类的方法? 没什么高大上
        new Thread(resource::print,"B").start();
    }
}

//资源类 实例变量，实例方法，加锁解锁操作
class Resource {
    private final Object lock = new Object();

    public void print () {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(200);
                    lock.notify(); //因为这里只有一个线程在等待锁，因此使用notify也是可以的
                    lock.wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果不加这句代码，则A执行完毕后，B永远处于wait状态，会发生死锁!!!
                //我们知道，notify只会唤醒一个等待当前锁的线程，此时只有一个B在等待，因此可以使用notify()
                lock.notify();
            }
        }
    }
}

