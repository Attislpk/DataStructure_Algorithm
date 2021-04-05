//875. 爱吃香蕉的珂珂
//https://leetcode-cn.com/problems/koko-eating-bananas/
//求解思路：利用二分查找求解

import java.util.Arrays;
import java.util.OptionalInt;

class Solution875 {
    public int minEatingSpeed(int[] piles, int H) {

        //吃香蕉的速度区间为1-piles.max
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r){  // l==r则已经得到所需要的值了，不需要再进行循环
            //假设的吃香蕉的速度为mid
            int mid = l + (r-l)/2; //向下取整， 选择向下取整或向上取整需要结合下文的循环不变量是否会进入死循环来判断, 死循环条件 mid=l
            if (eatingTime(piles,mid)<=H){
                //吃香蕉的速度满足要求，能不能减小呢？
                r = mid;
            }else {
                //香蕉吃的太慢了，需要加速
                l = mid +1; //破坏了死循环条件mid=l, 不会造成死循环
            }
        }
        return l; //l == r时退出循环，夹逼得到时间
    }
    private int eatingTime(int[] piles, int k){
        //计算以k的速度吃完piles中的香蕉所花的时间
        int res = 0;
        for (double pile: piles){
            res += Math.ceil(pile / k);
        }
        return res;
    }
}