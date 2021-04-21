package 剑指;

public class 剑指Offer05替换空格 {
}


class Solution05 {
    public static  String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ' ') {
                //[i,i+1),因此替换的是第i个位置的空格, 但是都用到替换函数了，岂不是有点鸡肋？
                stringBuilder.replace(i, i + 1, "%20");
            }
        }
        return stringBuilder.toString();
    }
//==================================================================================================
    public static  String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == ' ') stringBuilder.append("%20");
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy. ";
        System.out.println(replaceSpace(s));
    }
}