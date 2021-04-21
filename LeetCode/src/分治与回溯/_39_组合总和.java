package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _39_组合总和 {
}

//给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
//注意：candidates中的数字可以无限制重复被选取。

class Solution39 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        dfs(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    private void dfs(int[] candidates, int target, ArrayList<Integer> track, int start) {
       //terminator, target最后如果==0，则满足要求
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (target < 0) return;  //不符合要求

        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            //由于candicates中的数字可以重复无限选取，因此起点还是从i开始，不需要向前推进
            //同时，target向下传递的值为target - candidates[i]
            dfs(candidates, target - candidates[i], track, i);
            track.remove(track.size() - 1);
        }
    }
}