package 快排复习;

import java.util.Random;

//双路快排

/**
 * public class QuickSort1 {
 * public static <E extends Comparable<E>> void sort(E[] arr) {
 * Random rand = new Random();
 * sort(arr, 0, arr.length - 1, rand);
 * }
 * <p>
 * public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
 * //terminator
 * if (l >= r) return;
 * <p>
 * //process
 * int pivot = partition(arr, l, r, random);
 * //drill down
 * sort(arr, l, pivot - 1, random);
 * sort(arr, pivot + 1, r , random);
 * }
 * <p>
 * private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
 * int rand = random.nextInt(r - l + 1) + l;
 * swap(arr, l, rand);
 * <p>
 * //双路快排l,[l+1,i-1],i,j,[j+1,r]
 * int i = l + 1;
 * int j = r;
 * while (true) {
 * while (i <= j && arr[i].compareTo(arr[l]) < 0) i++;
 * while (j >= i && arr[j].compareTo(arr[l]) > 0) j--;
 * //i j 停止移动两种可能
 * if (i >= j) break;
 * swap(arr, i, j);
 * //继续推进
 * i++;
 * j--;
 * }
 * swap(arr, l, j);
 * return j;
 * }
 * <p>
 * private static <E> void swap(E[]arr, int l, int r) {
 * E temp = arr[l];
 * arr[l] = arr[r];
 * arr[r] = temp;
 * }
 * }
 */

public class QuickSort1 {
    public <E extends Comparable<E>> void quickSort(E[] arr) {
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random) {
        //base case 一个元素不需要排序
        if (l >= r) return;
        //process
        int pivot = partition(arr, l, r, random);
        // drill down
        quickSort(arr, l, pivot - 1, random);
        quickSort(arr, pivot + 1, r, random);
    }

    private <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        //l,[l+1,i-1],i,j,[j+1,r]
        //l >= r 已经被quickSort()拦截
        int rand = random.nextInt(r - l + 1) + l;
        swap(arr, l, rand);
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) i++;
            while (j >= i && arr[j].compareTo(arr[l]) > 0) j--;
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        //break条件是i==j，因此此题swap i和j是一样的
        swap(arr, l, j);
        return j;
    }

    private <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}