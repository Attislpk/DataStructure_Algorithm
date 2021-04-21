package 排序算法;

import java.util.Random;

public class QuickSort3ways1 {
    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        //terminator
        if (l >= r) return;

        int rand = (random.nextInt(r - l + 1)) + l;
        swap(arr, l, rand);

        //[l+1,lt],[lt+1,i-1],i,[gt,r]
        //process
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, gt, i);
            } else i++;
        }
        swap(arr, l, lt);
        //[l,lt-1],[lt,gt-1],[gt,r]
        //drill down
        sort(arr, l, lt - 1, random);
        sort(arr, gt, r, random);
        //restore
    }

    private static <E> void swap(E[] arr, int l, int r) {
        E temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
