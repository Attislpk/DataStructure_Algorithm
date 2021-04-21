package lambda表达式_2;

import org.junit.Test;

import java.util.function.Consumer;

public class LambdaDemo3 {

    @Test
    public void test1() {
        //如果不使用lambda表达式，通过匿名类实现接口
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println(money + "已经没了");
            }
        });
        //通过lambda表达式实现接口, 更加简洁
        happyTime(600, money->{ System.out.println(money + "也没了"); });
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }
}
