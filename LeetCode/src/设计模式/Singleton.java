package 设计模式;


//饿汉式
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
}

class SingletonF {
    private static volatile SingletonF instance = null;
    private SingletonF(){}

    public static SingletonF getInstance() {
        if (instance == null) {
            synchronized (SingletonF.class) {
                if (instance == null) {
                    instance = new SingletonF();
                }
            }
        }
        return instance;
    }
}

class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton + " - " +singleton1);

        SingletonF singletonF = SingletonF.getInstance();
        SingletonF singletonF1 = SingletonF.getInstance();
        System.out.println(singletonF + " - " +singletonF1);
    }
}



