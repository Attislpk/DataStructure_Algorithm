package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _131_分割回文串 {
}
//TODO 学了动态规划再来

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//回文串 是正着读和反着读都一样的字符串。
class Solution131 {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        process(s, 0, new ArrayList<String>());
        return res;
    }
    private void process(String str, int start, ArrayList<String> track) {
        //terminator 1.一个字母  2.多个字母且回文
        if(track.size() == 1) {
//            res.add()
        }
    }
}