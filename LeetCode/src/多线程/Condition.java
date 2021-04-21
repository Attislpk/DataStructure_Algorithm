package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//顺序打印多个线程 ABCABCABC......  使用Lock，Condition，await()和signal(),配合volatile
class ConditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 10; i ++) {
                shareData.printA();
            }
        }).start();

        new Thread (()->{
            for (int i = 0; i < 10; i++) {
                shareData.printB();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i ++) {
                shareData.printC();
            }
        }).start();
    }
}

class ShareData {
    private volatile int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            //判断
            while (num != 1) {
                condition1.await();
            }
            //干活
            System.out.println("A");
            //通知
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB () {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println("B");
            num = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC () {
        lock.lock();
        try {
            while (num != 3){
                //Causes the current thread to wait until it is signalled. await()和condition是相互匹配的方法
                condition3.await();
            }
            System.out.println("C");
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

