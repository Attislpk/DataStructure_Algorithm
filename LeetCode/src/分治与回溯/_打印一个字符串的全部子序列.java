package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _打印一个字符串的全部子序列 {
    private static final List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        //findSubStr(str, "", 0);
        findSubStr(str, new StringBuilder(), 0);
        res.forEach(System.out::println);
    }
    //深度优先遍历, 和括号匹配非常相似，基本一致，不过括号匹配还需要判断括号的情况,
    public static void findSubStr(String str, StringBuilder path, int depth) {
        //terminator
        if (depth == str.length()) {
            res.add(path.toString());
            return;
        }

        findSubStr(str, path.append(str.charAt(depth)), depth + 1);
        //这里的撤销选择是在添加之后，如果没有添加字符，则无需撤销选择
        path.deleteCharAt(path.length() - 1);
        findSubStr(str, path, depth + 1);
    }

    //深度优先遍历, 和括号匹配非常相似，基本一致，不过括号匹配还需要判断括号的情况, 下面是使用String
    public static void findSubStr(String str, String path, int depth) {
        //terminator
        if (depth == str.length()) {
            res.add(path);
            return;
        }
        //选择or不选择第i个位置的字符, 因为字符串是不可变的，相当于每一次都新建了一个字符串，因此不会干扰到其他字符串，所以不需要撤销选择
        findSubStr(str, path + str.charAt(depth), depth +1);
        findSubStr(str, path, depth +1);
    }
}
