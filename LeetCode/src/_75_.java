import java.util.Random;

public class _75_ {
}

//75. 颜色分类
//https://leetcode-cn.com/problems/sort-colors/


class Solution75 {
    public void sortColors(int[] nums) {
        //将1作为标定点 nums[0——zero]==0;nums[zero+1——i-1]==1;nums[two,nums.length-1]==2
        int zero = -1;
        int i = 0;
        int two = nums.length;
        while (i < two){
            if (nums[i] ==0){
                zero++;
                swap(nums,zero,i);
                i++;
            }else if (nums[i] == 2){
                two--;
                swap(nums,two,i);
            }else {
                //nums[i] == 1
                i++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



