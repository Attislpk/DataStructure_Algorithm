package 排序算法;

import java.util.Random;

public class QuickSort2ways {

    public static<E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        //terminator
        if (l >= r) return;

        //process
        int pivot = partition(arr, l, r, random);
        //drill down
        sort(arr, l, pivot - 1, random);
        sort(arr, pivot + 1, r, random);
        //restore
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int rand = (random.nextInt(r - l + 1)) + l;
        swap(arr,l,rand);
        //l,[l+1,i-1],i,j,[j+1,r]
        int i = l + 1;
        int j = r;
        while (true) {
            while (i<=j && arr[i].compareTo(arr[l]) < 0) i++; // >=0暂停
            while (i<=j && arr[j].compareTo(arr[l]) > 0) j--; // <=0暂停
            //i=j
            if (i >= j) break;
            // 交换元素
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, i);
        return i;
    }

    private static <E> void  swap(E[]arr, int l, int r) {
        E temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
