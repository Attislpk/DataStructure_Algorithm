package 动态规划算法.fibonacci;


import java.util.Arrays;

//动态规划
public class Solution3 {

    public int fib(int n){
       //定义用于存放结果的数组
        int[] result = new int[n+1];

        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }


    public static void main(String[] args) {
        int n = 42;
        Solution3 solution2 = new Solution3();

        double startTime = System.nanoTime();
        System.out.println("方法执行结果:"+solution2.fib(n));
        double endTime = System.nanoTime();
        System.out.println("运行时间："+(endTime-startTime)/1000000000.0);
    }
}
