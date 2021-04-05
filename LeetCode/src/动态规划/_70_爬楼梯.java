package 动态规划;//https://leetcode-cn.com/problems/climbing-stairs/
//使用动态规划的方式求解爬楼梯

import java.util.Arrays;

public class _70_爬楼梯 {
}


class Solution70 {

    public int climbStairs(int n) {
        return calcWays2(n);
    }


    //方法1：直接利用递归求解，和fibonacci数列的求解方式相同------>有多次重复计算，使用记忆化搜索
    public int calcWays(int n){
        //递归求解
        //边界条件
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //递归表达式
        return calcWays(n-1) + calcWays(n-2);
    }

    //记忆化搜索算法
    public int calcWays2(int n){
        int[] result = new int[n+1];
        Arrays.fill(result,-1);
        return calcWays2(n, result);
    }
    private int calcWays2(int n, int[] result){
        if(n ==1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(result[n] == -1){
            result[n] = calcWays2(n-1,result) + calcWays2(n-2,result);
        }
        return result[n];
    }

    //使用动态规划求解
    public int calcuWays3(int n){
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n; i++){
            result[i] = result[i-1] + result[i-2]; // result[3] = result[1] + result[2];
        }
        return result[n];
    }
}