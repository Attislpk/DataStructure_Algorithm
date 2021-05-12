package 剑指.动态规划之跳台阶;

public class 剑指Offer10斐波那契数列 {
}


class Solution10 {
    public int fib(int n) {
        //base case 拦截 0和1
        if (n == 0 || n == 1) return n;
        //只用于推断，因为0和1在上面已经被拦截
        int f0 = 0, f1 = 1;
        int f2;
        //计算从2开始推,n=2, 3, ...n
        for (int i = 2; i <= n; i++) {
            f2 = (f0 + f1)%1000000007;
            f0 = f1;
            f1 = f2;
        }
        //返回f1，因为f2已经赋值给f1了,但f2在上面没有初始化，因此return f1
        return f1;
    }
}
