package 左神算法.Basic.从暴力递归到动态规划.背包问题;

public class _0_1背包问题 {
}

/*
给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
其中第i个物品的重量为wt[i]，价值为val[i]，i从1开始,现在让你用这个背包装物品，最多能装的价值是多少？
 */
class SolutionPackage {
    //0-1 背包问题
    public static int getMax1(int[] wt, int[] val, int bagSize) {
        int N = wt.length;
        int[][] dp = new int[N + 1][bagSize + 1]; //dp[i][j] : 前i个物品，总重量为j时，能装下的最大价值
        //初始化 dp[0][...] = 0; dp[..][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= bagSize; j++) {
                //可以选择第i个物品，带条件 wt[i] <= j
                if (wt[i - 1] <= j) {
                    //两个状态都是旧状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    //不能选择第i个物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][bagSize];
    }

    public static int getMax(int[] wt, int[] val, int bagSize) {
        int N = wt.length;
        int[] dp = new int[bagSize + 1];
        for (int i = 1; i <= N; i++) {
            //利用两个旧状态[i-1]推出第[i]的状态，必须要逆推, 且if条件判断可以放到for循环中
            for (int j = bagSize; j >=wt[i - 1]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[bagSize];
    }


    public static void main(String[] args) {
        int[] wt = {3,4,5,1};
        int[] val = {5,1,7,2};
        int W = 11;
        System.out.println(getMax(wt, val, W));
         System.out.println(getMax1(wt, val, W));
    }
}