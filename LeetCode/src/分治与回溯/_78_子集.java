package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _78_子集 {
}

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。  题目条件是返回子集而非全排列，因此需要包括start下标
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

class Solution78 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> track, int start) {
        //terminator 题目只限定了不重复条件，而不重复在进行元素筛选时判断
        res.add(new ArrayList<>(track));

        //避免重复，每一次的start都要向前推进
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            //为什么是i+1不是start+1? 因为i需要从start推进到nums.length-1这些元素的推进， 而start+1只包括了下一个元素推进的情况
            dfs(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }
}