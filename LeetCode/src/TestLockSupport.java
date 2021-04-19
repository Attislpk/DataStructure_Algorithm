import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockSupport {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();


        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                if (i == 5) LockSupport.park();
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        LockSupport.unpark(t);

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("8 sec");
    }
}
