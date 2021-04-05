package 动态规划算法.fibonacci;


import java.util.Arrays;

//记忆化搜索
public class Solution2 {
    private int num;

    public int fib(int n){
       //初始化数组用于存放fib(n)的计算结果
        int[] result = new int[n+1];
        //使用Arrays工具将result中全部存放为-1，数组初始化完毕，传入递归的fib方法中
        Arrays.fill(result,-1);
        return fib(n,result);
    }

    private int fib(int n, int[] result){
        num++;

        if(n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
       if(result[n] == -1){
           result[n] = fib(n-1,result) + fib(n-2,result);
       }
       return result[n];
    }

    public int getNunm(){
        return num;
    }

    public static void main(String[] args) {
        int n = 42;
        Solution2 solution2 = new Solution2();

        double startTime = System.nanoTime();
        System.out.println("方法执行结果:"+solution2.fib(n));
        double endTime = System.nanoTime();

        System.out.println("运行时间："+(endTime-startTime)/1000000000.0);
        System.out.println("方法运行次数: "+ solution2.getNunm());
    }
}
