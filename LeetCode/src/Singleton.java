public class Singleton {
    //饿汉式
    private static final Singleton instance = new Singleton();

    private Singleton(){}

    public Singleton getInstance(){
        return instance;
    }
}

//DCL 饱汉式
class Singleton2 {
    //此处的volatile是为了防止指令重排，避免对象初始化问题
    private volatile static Singleton2 instance = null;

    private Singleton2(){}

    public Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class){
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
