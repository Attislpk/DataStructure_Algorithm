package 动态规划;

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//https://leetcode-cn.com/problems/integer-break/
//题解：https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/


import java.util.Arrays;

public class _343_IntegerBreak {

}


/**
 * 使用递归+记忆化搜索自顶向下进行求解
 */

class Solution {

    int[] result; //提升作用域
    public int integerBreak(int n) {
        //定义数组用于记忆化搜索
        result = new int[n + 1];
        return breakNum(n);
    }

    //此方法作用：将n拆分(至少拆分成两个数字)并且返回拆分后数字的最大乘积结果
    private int breakNum(int n) {
        //边界条件
        if (n == 1) {
            return 1;
        }

        if (result[n] != 0) {
            return result[n];
        }

        int res = -1;
        for (int i = 1; i<= n-1; i++){
            res = Math.max(res,Math.max(i*(n-i),breakNum((n-i))));
        }
        return result[n];
    }


    /**
     * 使用动态规划自底向上
     * result[i]中存放的结果是: 将数字i分割（至少两份）后，得到的最大乘积
     */
    class Solution2 {
        int[] result;

        public int integerBreak(int n) {
            result = new int[n+1];

            //result[i]中存放的结果是数字i分割之后乘积的最大值
            result[2]=1;
            for (int i = 3; i <= n; i++){ //求解result[i],从3~n
                //对i进行分割
                for(int j = 1; j <= i-1; j++){
                    //乘积最大值：j*(i-j), j*result[i-j],将i-j继续分割后得到的乘积最大值
                    result[i] = Math.max(result[i],Math.max(j*(i-j),j*result[i-j]));
                }
            }
            return result[n];
        }
    }
}