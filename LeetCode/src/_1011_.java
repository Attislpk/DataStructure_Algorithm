//1011. 在 D 天内送达包裹的能力
//https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
//关联题目 875. 爱吃香蕉的珂珂

import java.util.Arrays;

class Solution1011 {
    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        //最小和最大的装载量分别为l 和 r
        while (l <r){
            int mid = l + (r-l)/2; //死循环 mid = l;
            if (days(weights,mid)<=D){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

   private int days(int[] weights, int load){
        int cur_total = 0;
        int days = 0;
        for (int weight: weights){
            if (cur_total + weight <= load){ //只要此时的cur+weight<=load, 则可以将当前的weight加入，cur指针后移
                cur_total +=weight;
            }else {
                days++;
                cur_total = weight; //cur指针后移
            }
        }
        days++; //最后一个weight
        return days;
   }
}


