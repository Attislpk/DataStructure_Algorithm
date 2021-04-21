package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _77_组合 {
}

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
class Solution77 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0) return res;
        //显然 ,n是单调递增的，不存在重复元素，因此不需要进行排序
        //所有的组合问题、子集问题都需要标定下标, 此处题目规定start从1开始
        dfs(new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    private void dfs(ArrayList<Integer> track, int n, int k, int start) {
        //返回的所有子集中，只能选择长度=K的子集
        if (track.size() == k) {
            res.add(new ArrayList<>(track)); return;
        }

        //对i剪枝，如果此时的i后面的元素长度已经不可能到达K个了，那么没有必要继续了，因此进行剪枝
        // i到n的的元素个数=n-i+1, 每次最多可以选择K个元素，结合上track就还需要选K-track.size()个元素
        // i~n之间的元素个数是还可以被选中的，即n-i+1个元素一定要>=K-track.size()
        //那么有公式:n-i+1-(K-track.size()) >=0, ===> i <= n-(K-track.size())+1;
        for (int i = start; i <= n-(k-track.size()) + 1; i++) {
            track.add(i);
            dfs(track, n, k, i+1);
            track.remove(track.size() - 1);
        }
    }
}