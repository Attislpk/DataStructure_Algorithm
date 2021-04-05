package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_找到字符串中所有字母异位词 {
}


class Solution438 {
    public static List<Integer> findAnagrams(String s, String p) {
        //获取s和p的长度，将s和p对应的字频分别存放到数组中
        int ssize = s.length();
        int psize = p.length();
        List res = new ArrayList();
        if(ssize < psize){
            return res;
        }
        int freqs[] = new int[26];
        int freqp[] = new int[26];
        //直接获取s中的psize个元素进行比较
        for(int i = 0; i < psize; i++){
            freqp[p.charAt(i) - 'a']++;  //获取固定不变量
            freqs[s.charAt(i) - 'a']++;  //比较s中的第一个窗口

        }
        if(Arrays.equals(freqp,freqs)){
            res.add(0);
        }
        //循环不变量[r-psize,r]==>该窗口长度不变
        for (int r = psize; r < ssize; r++){
            freqs[s.charAt(r) - 'a']++;
            freqs[s.charAt(r-psize) - 'a']--; //滑动前的左窗口
            if(Arrays.equals(freqp,freqs)){
                res.add(r-psize+1);//滑动后的左窗口
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p).toString());
    }
}
