package 分治与回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_组合总和2 {
}

//给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。candidates中的每个数字在每个组合中只能使用一次。
class Solution40 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null ||candidates.length == 0) return res;
        //???到低需不需要used[]数组呢? 我认为是需要的，和90题非常相似, 在什么时候需要用到used数组?
        // 如果求解子集(存在重复元素的全排列)不能重复，需要使用used数组进行平级的判断, 例如 1 1` 2 3,  1 2 3 包括了 1` 2 3
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), used);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> track, boolean[] used) {
        //terminator
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break; //剪枝第一次
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue; //剪枝第二次
            used[i] = true;
            track.add(candidates[i]);
            //区别在于，此处不能重复使用元素，因此start需要不能仍然=i，而是需要向下推进
            dfs(candidates, target - candidates[i], i+1,track, used);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }
}
