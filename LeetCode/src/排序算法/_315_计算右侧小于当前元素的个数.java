package 排序算法;

import java.util.ArrayList;
import java.util.List;

public class _315_计算右侧小于当前元素的个数 {
}

//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution315 {
    private int[] index;
    private int[] aux;
    private int[] counter;
    public List<Integer> countSmaller(int[] nums) {
        final List<Integer> counts = new ArrayList<>();
        if (nums == null || nums.length < 2) return counts;
        int len = nums.length;

        aux = new int[len];
        counter = new int[len];
        index = new int[len];

        process(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            counts.add(counter[i]);
        }

        return counts;
    }

    private void process(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        process(nums, left, mid);
        process(nums, mid + 1, right);
        if (nums[mid] <= nums[mid + 1]) return;
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        while (p1 <= mid && p2 <= right) {
            //p2 >= p1,  TODO
            if (nums[p1] <= nums[p2]) {

                temp[i++] = nums[p1++];
            } else {
                //p1 > p2

                temp[i++] = nums[p2++];
            }
        }
        while (p1 <= left) temp[i++] = nums[p1++];
        while (p2 <= right) temp[i++] = nums[p2++];
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,6,1};
        Solution315 solution315 = new Solution315();
        System.out.println(solution315.countSmaller(arr));
    }
}