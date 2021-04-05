import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {


    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random(); //提前将对象创建出来，并将该对象传递到递归栈中，避免在递归中每次都需要创建对象
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        //边界条件(又忘了，没有边界条件的递归只能无限递归下去)
        if (l >= r) return;
        int p = partition(arr, l, r, random);
        //对p位置的左右区间分别partition，此处不包括p
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

    //返回值代表元素v的位置,元素v已经到自己在arr中应该所处的位置了
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        //对于每一个区间都需要进行随机化
        int rand = (random.nextInt(r - l + 1)) + l;
        SortingHelper.swap(arr, rand, l);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                SortingHelper.swap(arr, i, j);
            }
        }
        SortingHelper.swap(arr, l, j);
        return j;
    }


    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        Random random = new Random(); //提前将对象创建出来，并将该对象传递到递归栈中，避免在递归中每次都需要创建对象
        sort2ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition2ways(arr, l, r, random);
        //对p位置的左右区间分别partition，此处不包括p
        sort2ways(arr, l, p - 1, random);
        sort2ways(arr, p + 1, r, random);
    }

    //返回值代表元素v的位置,元素v已经到自己在arr中应该所处的位置了
    private static <E extends Comparable<E>> int partition2ways(E[] arr, int l, int r, Random random) {
        //对于每一个区间都需要进行随机化
        int rand = (random.nextInt(r - l + 1)) + l;
        SortingHelper.swap(arr, rand, l);
        int i = l + 1;
        int j = r;
        //双路快排
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) { //如果此处是<=0, 则对于完全相同的数组而言，i会不断++到j，然后跳出循环，
                // 将arr[i]和arr[l]互换，返回j(r), 下一次循环还是i++到j。。。导致区间划分不合理，复杂度退化为0(n^2)
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            //跳出上述while循环说明i和j都停止了，要么是需要交换元素，要么是i>=j
            if (i >= j) break; //i = j, arr[i] = arr[j] = arr[l]; i > j, 左右区间已排序完毕
            SortingHelper.swap(arr, i, j);
            //交换完毕之后i++, j--
            i++;
            j--;
        }
        SortingHelper.swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        Random random = new Random(); //提前将对象创建出来，并将该对象传递到递归栈中，避免在递归中每次都需要创建对象
        sort3ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        //对于每一个区间都需要进行随机化
        int rand = (random.nextInt(r - l + 1)) + l;
        SortingHelper.swap(arr, rand, l);

        //各区间的循环不变量为[l+1,lt];[lt+1,i-1],[gt,r],初始情况下各个区间的长度为-1
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            //=gt已经被判断过了
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++; //扩区间
                SortingHelper.swap(arr, i, lt);//换元素
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                SortingHelper.swap(arr, i, gt); //不需要i++
            } else {
                // arr[i] == arr[l];
                i++;
            }
        }
        SortingHelper.swap(arr, l, lt); //lt+1的区间已经相等了
        //各区间的循环不变量为[l,lt-1];[lt,gt-1],[gt,r]
        //对lt和gt所属的区间分别进行partition递归调用
        sort3ways(arr, l, lt - 1, random);
        sort3ways(arr, gt, r, random);
    }

    public static void main(String[] args) {
        int n = 100000;
//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        System.out.println("Random array: ");
//        SortingHelper.sortTest("QuickSort", arr);
//        SortingHelper.sortTest("QuickSort2ways", arr2);
//
//        Integer[] arr3 = ArrayGenerator.generateOrderdArray(n);
//        Integer[] arr4 = Arrays.copyOf(arr3, arr3.length);
//        System.out.println("Ordered array: ");
//        SortingHelper.sortTest("QuickSort", arr3);
//        SortingHelper.sortTest("QuickSort2ways", arr4);

        //重复元素
        Integer[] arr5 = ArrayGenerator.generateRandomArray(n, 1);
        Integer[] arr6 = Arrays.copyOf(arr5, arr5.length);
        Integer[] arr7 = Arrays.copyOf(arr6, arr6.length);
        System.out.println("Repeated array: ");
        SortingHelper.sortTest("QuickSort", arr5); //n = 100000, 4.351816 s
        SortingHelper.sortTest("QuickSort2ways", arr6); // n = 100000, 0.023244 s
        SortingHelper.sortTest("QuickSort3ways", arr7); //n = 100000, 0.006790 s  复杂度降为O(n)
    }
}

class MyQuickSort {
    private MyQuickSort() {
    }

    //公共的sort方法
    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    //递归sort方法
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        //边界条件
        if (l >= r) return;

        int pivot = partition(arr, l, r, random);
        sort(arr, l, pivot - 1, random);
        sort(arr, pivot + 1, r, random);
    }

    //分治partition方法, 完成区间划分, 返回标定点下标
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        //首先对区间进行随机化
        int p = (random.nextInt(r - l + 1)) + l;
        SortingHelper.swap(arr, l, p);
        //进行partition过程
        int j = l;
        int i = l + 1;
        while (i <= r) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                SortingHelper.swap(arr, i, j);
            }
            i++;
        }
        SortingHelper.swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random random) {
        int p = (random.nextInt(r - l + 1)) + l;
        SortingHelper.swap(arr, l, p);
        int i = l;
        int j = r;
        while (true) {
            while (i < j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j > i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i >= j) break;
            SortingHelper.swap(arr, i, j);
            i++;
            j--;
        }
        SortingHelper.swap(arr, l, j);
        return j;
    }


    private static<E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random ramdom) {
        //随机化
        int p = (ramdom.nextInt(r-l+1))+l;
        SortingHelper.swap(arr, l, p);

        //划分区间[l+1,lt],[lt+1,i-1],[gt,r] 区间的初始长度均为-1
        int lt = l;
        int i = l+1;
        int gt = r+1;
        while (i < gt){
            if (arr[i].compareTo(arr[l]) <0){
                lt++;
                SortingHelper.swap(arr,lt,i);
                i++;
            }else if (arr[i].compareTo(arr[l]) > 0){
                gt--;
                SortingHelper.swap(arr,gt,i);
            }else i++;
        }
        SortingHelper.swap(arr,l,lt);
        //区间变为[l,lt-1],[lt,gt-1],[gt,r]
        sort3ways(arr,l,lt-1,ramdom);
        sort3ways(arr,gt,r,ramdom);
    }
}
