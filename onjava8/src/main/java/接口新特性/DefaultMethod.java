package 接口新特性;

import org.junit.Test;

public interface DefaultMethod {
    //public abstract void show() 抽象方法
    void show();

    //public static void staticMethod()静态方法
    static void staticMethod(){
        System.out.println("我是static方法");
    }

    //public default void defaultMethod()默认方法
    default void defaulMethod(){
        System.out.println("我是default方法");
    }
}


