package 数组;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 求解思路:
 * 1.题目要求中出现长度最小的数组，使用滑动窗口   时间O(n)，空间O(1)
 * 2.窗口[r,l],r初始为0，l初始为-1，循环条件r<nums.size, 记录长度，取最小值返回
 */


public class _209_长度最小的子数组 {
}

class Solution209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1; //窗口初始长度为0
        int res = nums.length + 1; //设置一个不可能取到的值
        int sum = 0;
        while (l < nums.length ) {
            //r滑动条件：sum < r;  l滑动条件: sum >= target, 确定滑动窗口
            if (sum < target && r + 1 < nums.length) {  //sum>=target或者r到达右边界
                //r++;
                sum += nums[++r];  //需要对数组下标进行判断，防止越界, 此时这个sum和target的大小并不确定
            } else {
                //l++;
               sum -= nums[l++];  //此时sum和target的大小不确定，需要进行判断
            }
            //对窗口确定后的sum再进行判读, 确定sum和target的相互大小
            if(sum >= target){
                res = Math.min(res, r-l+1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        } else {
            return res;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        minSubArrayLen(target,nums);
    }
}
