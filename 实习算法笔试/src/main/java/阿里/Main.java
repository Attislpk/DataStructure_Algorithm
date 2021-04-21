package 阿里;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int k = 1;
        System.out.println(getMax(arr, k) + 1);
    }
    private static int getMax(int[] arr, int k) {
        int res = 0;
        //初始化最开始的res
        for (int i = 0; i < k; i ++) {
            res += arr[i];
        }
        //outStart对应起始位置
        for (int outStart = 0; outStart < arr.length - 1;) {
            map.put(outStart,res);
            res -= arr[outStart];
            if (outStart + 1 + k < arr.length) {
                res += arr[++outStart + k];
            }else {
                res += 1;
            }
        }
        return map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).
                limit(1).mapToInt(Map.Entry::getKey).toArray()[0];
    }
}