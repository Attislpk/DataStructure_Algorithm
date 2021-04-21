package 设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy2 {
}

interface People {
    void work();
    void salary(int salary);
}

class Teacher implements People {

    @Override
    public void work() {
        System.out.println("老师的工作是教书");
    }

    @Override
    public void salary(int sal) {
        System.out.println("工资是:"+sal);
    }
}

class Police implements People {

    @Override
    public void work() {
        System.out.println("警察抓小偷");
    }

    @Override
    public void salary(int salary) {
        System.out.println("工资是"+salary);
    }
}

class Handler implements InvocationHandler {
    //执行谁的方法？ 必须把被代理对象传进来呀
    private Object target;
    public Handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("上班，增强功能");
        //此处的method对象和args都是代理对象proxy传入的，因为代理对象和被代理对象实现了相同的接口，因此代理对象传入的方法、方法的参数和被代理对象是完全相同的
        //区别就在于，是谁去执行了这部分的逻辑，还是被代理对象target通过反射去调用的，只不过在方法调用的前后都可以进行动态的增强
        //好处在哪？如果有1000个对象需要进行增强，只用修改这里的增强代码就可以了，不用在原对象上进行改动
        method.invoke(target,args); //通过反射调用target对象的method方法，传入的参数是args
        System.out.println("下班，增强功能");
        return null;
    }
}

class Test2 {
    public static void main(String[] args) {
        //被代理对象
        Teacher teacher = new Teacher();
        //类加载器
        ClassLoader classLoader = teacher.getClass().getClassLoader();
        //生成代理对象，需要实现被代理对象实现的接口，才能够调用对应的方法, 方法的执行是交给handle去执行的
        //将代理对象传入handler，
        People teacherProxy = (People) Proxy.newProxyInstance(classLoader, new Class[]{People.class}, new Handler(teacher));
        teacherProxy.work();
        teacherProxy.salary(5000);
        //新增一个警察，对警察进行动态代理，只需要这么一段话
        Police police = new Police();
        People policeProxy = (People) Proxy.newProxyInstance(classLoader, new Class[]{People.class}, new Handler(police));
        policeProxy.work();
        policeProxy.salary(5000);
    }
}
