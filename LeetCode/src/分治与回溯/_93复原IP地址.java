package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _93复原IP地址 {
}
//TODO
class soluotion {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return list;
        dfs(s, list, 0, "", 0);
        return list;
    }

    void dfs(String s, List<String> list, int pos, String res, int count) {
        //1.已经分成了4段
        //2.s已经没有剩余元素可以分割
        if (count == 4 && pos == s.length()) {
            list.add(res);
            return;
        }

        //一共需要对str划分3次,4段, 每一次划分的长度可以是1~3
        for (int i = 1; i <= 3; i++) {
            //剪枝，当pos+i已经越界进行剪枝，由于i是递增的，没有必要继续下去了
            if (pos + i > s.length()) break;
            String section = s.substring(pos, pos + i); //section代表网段, 从[pos~pos+i)位置
            //如果section长度合法，且以0开头，则剪枝;  如果section大于256，也剪枝
            if (section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) > 255) break;
            //从左往右的尝试模型
            dfs(s, list, pos + i, count == 0 ? section : res + "." + section, count + 1);
        }
    }
}
