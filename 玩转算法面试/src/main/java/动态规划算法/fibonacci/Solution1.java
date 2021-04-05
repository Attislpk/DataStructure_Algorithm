package 动态规划算法.fibonacci;


//递归求解Fibonacci数列
public class Solution1 {
    private int num;

    public int fib(int n){
        num++;
        if(n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public int getNunm(){
        return num;
    }

    public static void main(String[] args) {
        int n = 42;
        Solution1 solution1 = new Solution1();

        double startTime = System.nanoTime();
        System.out.println("方法执行结果:"+solution1.fib(n));
        double endTime = System.nanoTime();

        System.out.println("运行时间："+(endTime-startTime)/1000000000.0);
        System.out.println("方法运行次数: "+ solution1.getNunm());
    }
}
