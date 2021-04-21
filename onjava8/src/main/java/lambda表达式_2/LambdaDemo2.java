package lambda表达式_2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LambdaDemo2 {

    public static void main(String[] args) {
        //lambda表达式的本质就是函数式接口的实例
        //例如对comparator接口的实现
        Comparator<Integer> comparator = (o1, o2) -> o2.compareTo(o1);
        System.out.println(comparator.compare(12, 13));

        Consumer<String> consumer = t -> System.out.println(t);
        consumer.accept("111");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("lucy", 76);
        map.put("tom", 92);
        map.put("jack", 86);
        //map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).forEach(System.out::println);
        map.entrySet().stream().filter(e1 -> e1.getKey().contains("l")).forEach(System.out::println); //predicate函数式接口
        map.entrySet().stream().sorted(); //comparator， 关系型函数式接口
        map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).limit(2).forEach(System.out::println);

    }
}
