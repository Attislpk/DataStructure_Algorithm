package 排序算法;

public class 剑指_Offer_51_数组中的逆序对 {
}

class Solution {
    public int reversePairs(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public int process(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + ((right - left) >> 1);

        int leftCount = process(nums, left, mid);
        int rightCount = process(nums, mid + 1, right);
        if (nums[mid] <= nums[mid+1]) return leftCount + rightCount;

        //对最后的两个数组进行merge操作
        int remainCount = merge(nums, left, mid, right);
        return leftCount + rightCount + remainCount;
    }

    public int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        int count = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[i++] = nums[p1++];
            } else {
                //p1 > p2，则p1~mid都>p2
                count += (mid - p1 +1);
                temp[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) temp[i++] = nums[p1++];
        while (p2 <= right) temp[i++] = nums[p2++];

        for (i = 0; i < temp.length; i++) {
            nums[i + left] = temp[i];
        }
        return count;
    }
}
