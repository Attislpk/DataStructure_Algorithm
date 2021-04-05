
//https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
//剑指 Offer 40. 最小的k个数

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _40_ {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//reverseOrder后pq将按照最大堆的逻辑来执行
        for (int i = 0; i < k; i++){
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++){
            if (!pq.isEmpty() && arr[i] < pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
       int[] ret = new int[k];
        for (int i = 0; i < k; i++){
            ret[i] = pq.remove();
        }
        return ret;
    }
}
