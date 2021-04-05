public class StringDemo {

    public static void main(String[] args) {
        String s1 = "abc"; //字面量赋值，直接存储在Heap中的字符串常量池
        String s2 = new String("abc"); //new的方式，和正常类的实例化一样，实例在Heap上

        System.out.println(s1 == s2); //false, 一个指向的是字符串常量池中的abc，一个是堆上的abc对象

        String s3 = s2.intern(); //intern():查询该字符串在字符串常量池中是否存在，存在直接返回引用，不存在则常量池中创建并返回引用
        System.out.println(s1 == s3); //true, 因为abc已经在常量池中存在了，因此直接返回该abc字符串的引用即可

        String s4 = "a" + "bc"; //编译器提前优化，s4 = "abc"
        System.out.println(s1 == s4); //true, 编译器优化，s4直接指向字符串常量池中的"abc"

        String s5 = new String("a") + "bc"; //一共创建了3个对象，"bc"在字符串常量池中,"a"在堆上，"abc"在堆上
        System.out.println(s1 == s5);//false, new出来的对象，指向堆上的内存地址
        System.out.println(s1 == s2);//false, new出来的对象内存地址都不同

        String s6 = "abc"; //字符串常量池中已经存在了"abc"，直接返回
        System.out.println(s1 == s6);//true 和s1指向字符串常量池中的"abc"
    }
}
