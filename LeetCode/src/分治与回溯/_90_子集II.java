package 分治与回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_子集II {
}

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

class Solution97 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>(), 0, used);
        return res;
    }
    private void dfs(int[] nums, ArrayList<Integer> track, int start, boolean[] used) {
        //terminator, 在此处也可以使用HashSet或者contains方法去重，但是这样是不剪枝的结果，时间复杂度会很高,剪枝放在下面判断，此处的结果都是不重复的
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            //  如果nums[i] == nums[i-1], nums[i-1]尝试的所有子集一定包括了nums[i]想要尝试的子集, 并且
            //used[i-1]还没被用过，说明nums[i-1]和nums[i]是平级关系
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] =true;
            track.add(nums[i]);
            dfs(nums, track, i + 1, used);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }
}