package 设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxy {
}

interface ICalc {
    int add(int a, int b);
    void sub(int a);
}

class IcalImpl implements ICalc{

    @Override
    public int add(int a, int b) {
        int r = a + b;
        System.out.println("add");
        return r;
    }

    @Override
    public void sub(int a) {
        System.out.println("print");
    }
}

        //当我们通过动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用，看如下invoke方法：
class MyHandler implements InvocationHandler {
    //真实对象，需要注入的
    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

            /**
             * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
             * method:我们所要调用某个对象真实的方法的Method对象
             * args:代理对象方法传递的参数
             */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始，参数是!!!:"+ Arrays.toString(args));
        //此处传入的method是通过反射获取的method对象, 调用target的invoke方法，参数是args
        Object result = method.invoke(target, args);
        System.out.println("结束，结果是!!!:"+result);
        return 0;
    }
}

class Test {
    public static void main(String[] args) {
        //真实对象, ICalc接口的实现类
        IcalImpl ical = new IcalImpl();
        //现在需要创建ical这个对象的代理类，需要什么东西？
        //JDK动态代理要求，代理类也必须实现ical实现的接口，代理类的创建需要类的加载，因此也需要类的加载器
        ClassLoader classLoader = ical.getClass().getClassLoader();
        //声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法
        //一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。
        ICalc proxy = (ICalc) Proxy.newProxyInstance(classLoader, new Class[]{ICalc.class}, new MyHandler(ical));

        proxy.add(1,2);
        proxy.sub(3);
    }
}