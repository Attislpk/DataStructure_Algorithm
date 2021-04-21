package lambda表达式_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("张三丰,30");
        arr.add("张无极,30");
        arr.add("张敏,30");
        arr.add("章鱼哥,30");
        arr.add("王祖贤,30");
        arr.add("林青霞,30");

        List<String> list = arr.stream().filter(s -> s.contains("张")).filter(s -> s.split(",")[0].length() == 3).collect(Collectors.toList());
        System.out.println(list);

    }
}
