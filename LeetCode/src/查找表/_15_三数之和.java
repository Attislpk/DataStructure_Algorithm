package 查找表;

import java.util.*;

public class _15_三数之和 {
}


class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3){
            return res;
        }

        //排序，利用对撞指针求解
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if( i > 0 && nums[i] == nums[i-1]) continue;//去重,i=0时不进行判断

            //利用对撞指针求解
            int l = i+1;
            int r = nums.length -1;
            while (l < r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum == 0){
                    //满足条件，先放入答案
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //去重操作
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    //判断下一组指针
                    l++;
                    r--;
                }else if (sum < 0){
                    l++;
                }else {
                    assert sum > 0;
                    r--;
                }
            }
        }
        return res;
    }
}