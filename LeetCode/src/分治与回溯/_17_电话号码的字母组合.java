package 分治与回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _17_电话号码的字母组合 {
}

class Solution17 {
    private final ArrayList<String> res = new ArrayList<>();
    String[] strings = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        process(digits, 0, new StringBuilder());
        return res;
    }

    private void process(String digits, int depth, StringBuilder track) {
        //terminator  此处的depth和track.length()相同，因为每一层只会选择一个char
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return; //如果不加return，char c = digits.charAt(depth)数组会下标越界
        }

        //process
        char c = digits.charAt(depth);
        String subStr = strings[c - '2'];
        for (int i = 0; i < subStr.length(); i++) {
            track.append(subStr.charAt(i));
            process(digits, depth + 1, track);
            track.deleteCharAt(track.length() - 1);
        }
    }


    public List<String> letterCombinations2(String digits) {
        //队列结构, 最后返回的就是队列中存储的结果
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] strings = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        //初始化
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String subStr = strings[c - '2'];

            //队列中的每一个元素和子串进行拼接，拼接队列中已有元素的次数
            int size = res.size();
            for (int j = 0; j < size; j++) {
                //取出队列中的元素，逐个进行拼接
                String temp = res.remove(0);
                for (int k = 0; k < subStr.length(); k++) {
                    //将队列中的原子串和subStr中的字符进行拼接，并重新添加到队列中，等待下一次取出，再拼接......
                    res.add(temp + subStr.charAt(k));
                }
            }
        }
        return res;
    }
}