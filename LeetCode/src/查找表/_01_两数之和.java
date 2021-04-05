package 查找表;

import java.util.HashMap;
import java.util.Map;

public class _01_两数之和 {
}
//1. 两数之和
/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 */
//https://leetcode-cn.com/problems/two-sum/



class Solution01 {

    //使用HashMap存储元素a，查找target-a,为了防止相同元素进行覆盖，不能一次性将所有元素全部添加到HashMap中，需要进行逐次的遍历判断
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
                //在查找表中查找是否有满足要求的元素
                if(map.containsKey(target - nums[i])){
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                }
        }
        return res;
    }
}