import java.awt.print.PrinterGraphics;
import java.util.Arrays;

public class InsertSort {

    private InsertSort() {
    }

//    //确定第i个元素在0~i的位置
//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        //对arr.length-1个元素都需要进行排序，第一个元素不需要排序
//        for (int i = 1; i < arr.length; i++) {
////            for (int j = i; j - 1 >=0; j--){
////                if (arr[j].compareTo(arr[j-1])<0){
////                    SortingHelper.swap(arr,j,j-1);
////                }else {
////                    break;
////                }
//            //等价于
//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                SortingHelper.swap(arr, j, j - 1);
//            }
//        }
//    }


    //确定第i个元素在0~i的位置
    public static <E extends Comparable<E>> void sort(E[] arr) {
        //对arr.length-1个元素都需要进行排序，第一个元素不需要排序
        for (int i = 1; i < arr.length; i++) {
            //插入排序的小优化
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            //如果在for(定义j，则j在for循环后被回收，因此需要提升j的作用域到for循环上)
            arr[j] = temp;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            //插入排序的小优化
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= l && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            //如果在for(定义j，则j在for循环后被回收，因此需要提升j的作用域到for循环上)
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] size={10000,100000};
        for(int n:size){
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            System.out.println("Random array: ");
            SortingHelper.sortTest("InsertSort2", arr);
            SortingHelper.sortTest("SelectionSort",arr2);
        }

        for(int n:size){
            Integer[] arr = ArrayGenerator.generateOrderdArray(n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            System.out.println("Ordered array: ");
            SortingHelper.sortTest("InsertSort2", arr);
            SortingHelper.sortTest("SelectionSort",arr2);
        }
//        SortingHelper.sortTest("SelectionSort", arr2);
    }
}
