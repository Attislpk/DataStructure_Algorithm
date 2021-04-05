package 栈_队列_优先队列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_前K个高频元素 {
}

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

class Solution {
    public int[] topK(int[] nums, int k) {
        assert k > 0;

        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //创建大顶堆，自定义comparator，规则为nums[i]的value进行比较
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((x,y)->(y.getValue().compareTo(x.getValue())));
        pq.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
         res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{1,1,1,2,2,2,3};
        int k = 2;
//        System.out.println(Arrays.toString(topK(nums, k)));
    }
}