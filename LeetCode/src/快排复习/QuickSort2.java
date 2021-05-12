package 快排复习;

import java.util.Random;

public class QuickSort2 {

    public <E extends Comparable<E>> void quickSort(E[] arr) {
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random) {
        //base case
        if (l >= r) return;
        int rand = random.nextInt(r - l + 1) + l;
        swap(arr, l, rand);
        //process
        int i = l + 1;
        int lt = l;
        int gt = r + 1;
        //l,[l+1,lt],[lt+1,i-1],i,[gt,r]
        while (l < gt) {
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
        quickSort(arr, l, lt - 1, random);
        quickSort(arr, gt, r, random);
    }

    private <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     public static<E extends Comparable<E>> void sort(E[] arr) {
     Random random = new Random();
     sort(arr, 0, arr.length - 1, random);
     }
     private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
     int rand = random.nextInt(r - l + 1) + l;
     swap(arr, rand, l);
     //terminator
     if (l >= r) return; //l,[l+1,lt],[lt+1,i-1],i,[gt,r]
     //process l,[l+1,lt],[lt+1,i-1],i,[gt,r]
     int lt = l;
     int gt = r + 1;
     int i = l + 1;
     while (i < gt) {
     if (arr[i].compareTo(arr[l]) < 0) {
     lt ++;
     swap(arr, lt, i);
     i ++;
     }
     else if (arr[i].compareTo(arr[l]) > 0) {
     gt --;
     swap(arr, gt, i);
     }else i++;
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
     */
}