package 排序算法;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static<E extends Comparable<E>> void sort(E[] arr) {
        Random rand = new Random();
        sort(arr, 0, arr.length - 1, rand);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rand) {
        //terminator
        if (l >= r) return;

        //process
        int pivot = partition(arr, l, r, rand);

        //drill down
        sort(arr, l, pivot - 1, rand);
        sort(arr, pivot + 1, r, rand);
    }

    private static <E extends Comparable<E>>int partition(E[] arr, int l, int r, Random rand) {
        //随机标定点
        int randIndex = rand.nextInt(r - l + 1) + l;
        swap(arr, l, randIndex);

        //选择l位置的元素为标定点，arr[l+1,j] < v; arr[j+1, i] >= v
        int j = l; //
        for (int i = l; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
