package 快排复习;

import java.util.Random;

//双路快排
public class QuickSort1 {
    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rand = new Random();
        sort(arr, 0, arr.length - 1, rand);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        //terminator
        if (l >= r) return;

        //process
        int pivot = partition(arr, l, r, random);
        //drill down
        sort(arr, l, pivot - 1, random);
        sort(arr, pivot + 1, r , random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int rand = random.nextInt(r - l + 1) + l;
        swap(arr, l, rand);

        //双路快排l,[l+1,i-1],i,j,[j+1,r]
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) i++;
            while (j >= i && arr[j].compareTo(arr[l]) > 0) j--;
            //i j 停止移动两种可能
            if (i >= j) break;
            swap(arr, i, j);
            //继续推进
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[]arr, int l, int r) {
        E temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
