package 剑指.动态规划之跳台阶;

public class 剑指Offer10青蛙跳台阶问题 {
}

class Solution10_2 {
    public int numWays(int n) {
        //base case 拦截0 ,1
        if (n == 0 || n == 1) return 1;
        //基本条件f0,f1
        int f0 = 1, f1 = 1, f2;
        //从2开始推到n
        for(int i = 2; i <=n ;i++) {
            f2 = (f0 + f1)%1000000007;
            f0 = f1;
            f1 = f2;
        }
        //返回f1，因为f2已经赋值给f1了,但f2在上面没有初始化，因此return f1
        return f1;
    }
}
