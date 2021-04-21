package 分治与回溯;

import java.util.ArrayList;
import java.util.List;

public class _93_复原IP地址 {
}

class Solution93 {

    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        //s, count代表切分的段数，pos代表切分的指针位置, res用于存放结果
        dfs1(s,"" , res,0, 0);
        return res;
    }
    private void dfs1(String s, String track ,List<String> res,int count, int pos) {
        //terminator
        if (count == 4 && pos == s.length()) {
            res.add(track);
            return;
        }

        //process 每一次可以切分1, 2, 3个数字
        for (int i = 1; i <= 3; i++) {
            //第一次剪枝
            if (pos + i > s.length()) break;
            String section = s.substring(pos, pos + i);
            //第二次剪枝, 如果网段长度>1且以0开头(0.是合法的，但是0x是不合法的，因此长度>1且以0开头不合法)，或者对应的数字大于255，也无效
            if (section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) > 255) break; //section代表网段, 从[pos~pos+i)位置
            //从左往右的尝试模型,由于下面要先计算track，因此count应该放在track的后面，count++之后再计算track是错误的
            dfs1(s, count == 0 ? section : track + "." + section, res,count + 1, pos + i);
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        dfs(s, "", 0, 0, res);
        return res;
    }
    private void dfs(String s, String track, int pos, int count, List<String> res) {
        //terminator
        if (count == 4 && pos == s.length()) {
            res.add(track);
            return;
        }

        //process 在此处已经进行了选择，没有需要回退的情况
        for (int i = 1; i <=3; i++) {
            if (pos + i > s.length()) break;
            String section = s.substring(pos, pos + i);
            if (section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) > 255) break;
            dfs(s, count == 0 ? section : track + "." + section, pos + i, count + 1, res);
        }
    }
}

