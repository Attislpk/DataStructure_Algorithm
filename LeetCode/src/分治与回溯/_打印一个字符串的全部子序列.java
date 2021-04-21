package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _打印一个字符串的全部子序列 {
    private static final List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        findSubStr(str, "", 0);
        res.forEach(System.out::println);
    }

    //深度优先遍历, 和括号匹配非常相似，基本一致，不过括号匹配还需要判断括号的情况
    public static void findSubStr(String str, String path, int depth) {
        //terminator
        if (depth == str.length()) {
            res.add(path);
            return;
        }
        //选择or不选择第i个位置的字符
        findSubStr(str, path + str.charAt(depth), depth +1);
        findSubStr(str, path, depth +1);
    }
}
