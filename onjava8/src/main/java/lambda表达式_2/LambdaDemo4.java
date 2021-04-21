package lambda表达式_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaDemo4 {

    @Test
    public void test() {
        //匿名类的方式实现pre接口
        List<String> list = Arrays.asList("北京", "南京", "西京", "东京", "天津");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");  //pre.test(str) 完成的是这个逻辑
            }
        });
        System.out.println(list1);

        //使用lambda表达式实现predicate接口
        System.out.println(filterString(list, s -> s.contains("京")));


    }

    //filterString，将所有通过pre.test()的词语加入到新的队列中,具体的test实现在predicate的视线中确定
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        List<String> res = new ArrayList<>();
        for (String str: list) {
            if (pre.test(str)) {
                res.add(str);
            }
        }
        return res;
    }
}
