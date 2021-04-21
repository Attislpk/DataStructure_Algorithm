package 线程创建_1;

import java.util.HashMap;

public class StreamDemo1 {


        public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("lucy", 76);
            map.put("tom", 92);
            map.put("jack", 86);
            // 按照 Key (名字)进行排序 ,并打印
            map.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).forEach(System.out::println);
            System.out.println("-------分割线----------");
            // 按照value(分数) 进行排序,并打印
            map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).forEach(System.out::println);

    }
}
