package 数组;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _76最小覆盖子串_ {
}


class Solution76 {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        //需求Map和实际Map
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        //初始化need表（参考表）
        for(char ch: t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int l = 0;
        int r = 0; //初始窗口大小为1
        int start = 0;
        int size = s.length() + 1; //子串的最大的长度为s.length,因此此处的size是无效的,用于结果判断
        int valid = 0; //用于标识window中有效字符的个数, 等于非重复字符的个数

        while (r < s.length() ){
            char ch = s.charAt(r);
            r++; //补充window内的字符
            if(need.containsKey(ch)){ //如果need该字符
                //更新window中的字符
                window.put(ch,window.getOrDefault(ch,0)+1);
                if(window.get(ch).equals(need.get(ch))){
                    //如果window中ch的个数和need中ch的个数相同，则说明need中ch已经满足要求,注意重复的ch必须全部满足后才有valid++
                    valid++;
                }
            }
            //当valid和need.size相等时，window中的字符串包含了t，但不一定是最短的
            while (valid == need.size()){
                //对start，size进行更新
                if(r - l < size){
                    start = l;
                    size = r - l;
                }
                //可能后面还有更小的子串，因此l需要向右滑动
                ch = s.charAt(l);
                l++;
                if(need.containsKey(ch)){//如果丢掉的是一个需要的字符
                    if(window.get(ch).equals(need.get(ch))){
                        //如果window中所有的ch字符都没了，则减去一个有效字符
                        valid --;
                    }
                    window.put(ch,window.getOrDefault(ch,0)-1);
                }
            }
        }
        return size==s.length()+1? "":s.substring(start,start+size); //注意 substring(int startIndex, int endIndex);
    }

    public static String minWindow2(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c :  t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = s.length()+1;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 判断取出的字符是否在字串中
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩（已经找到合适的覆盖串）
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }

            }
        }

        return len == s.length()+1 ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        String s = "A";
        String t = "A";
        System.out.println(minWindow(s, t));
    }
}
