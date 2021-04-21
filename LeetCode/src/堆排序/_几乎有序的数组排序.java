package 堆排序;

import java.util.PriorityQueue;

public class _几乎有序的数组排序 {
}

/**
 * 已知一个几乎有序的数组，如果排好序，每个元素的移动距离不超过k，并且k相对于数组长度是比较小的。  也就是说每K个元素中的最小值可以确定
 * 选择一种合适的算法
 */

class SortArrayDistanceLessK {
    private int[] arr;
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->{return o2.compareTo(o1);});

    }




    public static void move(int[] arr, int k) {
        if (k == 0) return;
        //默认小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        //将前k/len-1范围取小的元素加入minHeap中   先把前面k个数加入堆，已知排好序的第一个节点必然在前面k个数中
        while (index < Math.min(arr.length, k)) {
            minHeap.add(arr[index++]);
        }

        //从堆中弹出最小值，依次放入数组，则最终结果就是排好序的 小根堆/最小堆
        int i = 0; //排好序后的数组元素下标, 前k个元素已经存放在heap中
        for (; i < arr.length; i++, index++) {
            arr[i] = minHeap.poll(); //k个元素中的最小值
            minHeap.add(arr[index]); //继续从index位置将元素从数组中添加到堆中
        }

        //当数组中元素已经全部在堆中，且此时堆还不为空，则将剩余元素弹出添加到数组中
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }
    }
}