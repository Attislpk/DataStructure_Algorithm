package 设计模式;

public class Template {
}

abstract class MyTemplate {

    public void test() {
        System.out.println("开始");
        //调用用户自行实现的方法
        code();
        System.out.println("结束");
    }

    //用户自行实现的方法
    abstract void code();
}

class Temp1 extends MyTemplate{
    @Override
    void code() {
        System.out.println("我是temp1的方法");
    }

    //此处执行test方法其实是调用父类中的test方法，然后由于子类重写了code方法，按照就近原则会调用子类的code
    @Override
    public void test() {
        super.test();
    }
}
class Temp2 extends MyTemplate {
    @Override
    void code() {
        System.out.println("我就要重写test方法");
    }
    @Override
    public void test() {
        System.out.println("我重写了test，现在不会有code了");
    }
}

class TestTemplate{
    public static void main(String[] args) {
        Temp1 temp1 = new Temp1();
        //Temp1继承了父类中的test和code方法，而没有对test方法进行修改，因此如果执行test方法
        //就会调用Temp1中重写的code()方法， test()中的code方法就变成了子类自己的逻辑，而其他的部分
        //还是从父类中继承过来的
        temp1.test();
        Temp2 temp2 = new Temp2();
        temp2.test();
    }
}