package 堆排序;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class _347_前K个高频元素 {
}
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//Entry<元素，频率> 根据频率进行排序并输出对应的元素
class Solution347 {
    public int[] topKFrequent1(int[] nums, int k) {
       if (nums == null || nums.length == 0)  return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        //<元素，频率>
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((o1,o2)->o2.getValue().compareTo(o1.getValue()));
        //一次性全部加入
        maxHeap.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }


    public int[] topKFrequent2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //这个list包括nums.length-1个元素
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    //stream1 半stream，更容易理解
    public int[] topKFrequent3(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        return map.entrySet().stream().sorted((o1,o2)->o2.getValue().compareTo(o1.getValue())).limit(k)
                .mapToInt(Map.Entry::getKey).toArray();
    }
}