package lambda表达式_2;

import org.junit.Test;

import java.util.ArrayList;

public class StreamDemo2 {

    public static int value;
    public int value2;

    @Test
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("张三丰");
        arr.add("张无极");
        arr.add("张敏");
        arr.add("章鱼哥");
        arr.add("王祖贤");
        arr.add("林青霞");

        // 输出list中字符串长度为3的元素 用方法引用的方式输出

        // 输出list中以张开头的元素

        // 输出list中字符串中以张开头且长度为3的元素
    }

}
