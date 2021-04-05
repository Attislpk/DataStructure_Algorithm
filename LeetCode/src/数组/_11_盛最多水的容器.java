package 数组;

public class _11_盛最多水的容器 {
}



class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        int res = 0;
        while (l < r){
            //高的最小值*底
           area =  Math.min(height[l],height[r])*(r-l);
           res = Math.max(area,res);
           if(height[l] < height[r]){
               l++;
           }else {
               r--;
           }
        }
        return res;
    }

}