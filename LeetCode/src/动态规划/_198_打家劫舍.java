package 动态规划;

public class _198_打家劫舍 {
}


/**
 * 使用递归+记忆化搜索自顶向下求解
 */
class Solution198 {
    int[] memo;

    public int rob(int[] nums) {
        return tryRob(nums,0);
    }

    //考虑抢劫nums[index,nums.size()-1]范围内的房子
    private int tryRob(int[] nums, int index) {
        //边界条件
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] != 0){
            return memo[index];
        }

        int res = 0;
        //i代表房子的下标
        for(int i = index; i <= nums.length-1; i++){
            //尝试抢劫房屋i，还要继续尝试去抢劫index+2后面的房屋
           res = Math.max(nums[i]+tryRob(nums,index+2),res);
        }
        memo[index] = res;
        return res;
    }


    /**
     *  使用动态规划求解
     */
    class Solution198_2 {
        public int rob(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            /**
             * 标签：动态规划
             * 动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
             * 由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
             * 时间复杂度：O(n)n 为数组长度
             */
            //从左往右的尝试模型，变量为房子的索引i
            int n = nums.length;
            int[] dp = new int[n+1];
            dp[1]=nums[0];
            for(int i = 2; i <= n; i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }
            return dp[n];
        }
    }
}