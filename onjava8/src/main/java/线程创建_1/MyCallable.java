package 线程创建_1;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return new String("创建线程的方式4：实现callable接口");
    }
}
