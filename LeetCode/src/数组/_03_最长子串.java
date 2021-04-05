package 数组;

import java.util.*;

public class _03_最长子串 {
}


/**
 *使用滑动窗口求解最长字串
 * 1.窗口大小[l,r], l from 0 to size-1; r from -1 to size -1
 * 2.空间换时间，使用256字节大小的数组统计出现频率，避免对每个子串的遍历
 *
 */

class Solution03 {
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;  //滑动窗口为[l,r]，在l-r窗口内的子串不重复, 初始长度为0
        int res = 0;
        int[] freq = new int[256];
        while (l < s.length()){ //循环条件是只要l还能取值,l可以在r的右侧，在下次判断之后r和l会重合
            if( r+1 <s.length() && freq[s.charAt(r+1)] == 0){ //定义域+判断条件, indexOf(int x)，返回x第一次出现的索引;ChatAt(int x)才是x处的字符
                //r++
                //freq[s.charAt(++r)] = 1;
                freq[s.charAt(++r)] ++; //用++更严谨
            }else{
                //l++;
                freq[s.charAt(l++)] --;  //直到子串中没有重复元素，r++
            }
            res = Math.max(res,r-l+1);      //结果是最长的子串，因此是res的最大值
        }
            return res;
    }

    public static void main(String[] args) {
        String s = "abcbcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}