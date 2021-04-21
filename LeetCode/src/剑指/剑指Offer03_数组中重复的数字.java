package 剑指;

import java.util.*;
import java.util.stream.Stream;

public class 剑指Offer03_数组中重复的数字 {
}

class Solution03 {
    //使用hashSet存储遍历过的元素，如果重复出现就返回, 时间O(N),空间O(N)
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num :nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    //使用原地置换，使得每一个元素回到其应该在的索引位置，如果重复则输出该元素， 时间
    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            //元素和索引匹配，
            if (nums[i] == i) {
                i ++;
                continue;
            }
            //元素和索引不匹配，2种情况，
            //1.当前索引对应的元素不存在，说明存在重复的元素且把当前索引对应的元素给挤掉了
            //2.当前索引对应的元素存在，只是不在对应的位置上
            //首先碰碰运气，看看当前索引对应的元素，是否和当前元素的索引对应的值重复，例如nums[3]=5, nums[5]=5
            if (nums[i] == nums[nums[i]]) return nums[i];
            //如果没有碰到，则交换索引和索引的元素的索引
            //nums[3]=5, nums[5]=4, nums[4]=1,nums[1]=...直到找到索引匹配或重复的元素
            int j = nums[i];
            nums[i] = nums[j];
            nums[j] = j;
        }
        return -1;
    }
}