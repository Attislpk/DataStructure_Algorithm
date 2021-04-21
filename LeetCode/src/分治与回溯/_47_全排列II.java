package 分治与回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_全排列II {
}

//给定一个可包含重复数字的序列 nums ，按任意顺序返回所有不重复的全排列。
class Solution47 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        //对于包含重复数字的序列，先进行一次排序，便于比较重复元素
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), used);
        return res;
    }
    private void dfs(int[] nums, ArrayList<Integer> track, boolean[] used) {
        //terminator
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //用过的元素不能再用
            if (used[i]) continue;
            /**
             *  分析used[i-1]和used[i]的关系:used[i-1]在used[i]之前，理论上将应该比used[i]先被使用到，即used[i-1]是used[i]的父节点
             *  然而现在used[i-1]没有在父节点中出现，因为used[i-1]如果在一条支线上被使用则肯定早于used[i]
             *  因此只能说明used[i-1]和used[i]不是父子关系，而是平级关系，因此used[i]和used[i-1]是同样的枝，应该被减掉
             */
            //重复的元素不能处于平级, 即used[i]和used[i-1]相同，且used[i-1]没有被使用
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            track.add(nums[i]);
            dfs(nums, track, used);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }
}