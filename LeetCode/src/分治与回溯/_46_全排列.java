package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
}

//给定一个 没有重复 数字的序列，返回其所有可能的全排列, 对于有重复元素的数组，返回不重复的全部排列47题
class Solution46 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] nums, ArrayList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            dfs(nums, track);
            track.remove(track.size()-1);
        }
    }
}
class Solution46_2 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>(),used);
        return res;
    }
    private void dfs(int[] nums, ArrayList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            dfs(nums, track, used);
            used[i] = false;
            track.remove(track.size()-1);
        }
    }
}