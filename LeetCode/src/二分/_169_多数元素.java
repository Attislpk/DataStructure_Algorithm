package 二分;

import java.util.Arrays;

public class _169_多数元素 {
}

class Solution {
    //1.for循环遍历，使用hashmap进行存储，时间复杂度O(N),空间复杂度O(N)
    //2. 对nums进行排序，返回mid位置的值就是多数元素,简单的二分，事件复杂度O(N*logN), 空间复杂度O(1)
    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    //尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
    //摩尔投票法 对拼消耗
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int candidate = nums[0];
        int votes = 1;
        for (int n: nums) {
            if (n == candidate) votes ++;
//            else if (n != candidate) votes --;
//            if (votes == 0) {
//                candidate = n;
//            }
            //上述代码优化, 到这个分支说明n != candidate
            else if (--votes == 0) {
                candidate = n;
                votes = 1;
            }
        }
        return candidate;
    }
}
