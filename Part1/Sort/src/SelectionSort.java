import java.util.Arrays;

public class SelectionSort {
    //功能类，不需要具体的实现，直接通过static调用内部方法
    private SelectionSort(){}

    //调用该方法的元素需要实现comparable接口
    public static<E extends Comparable<E>> void sort(E[] arr){

        for (int i = 0; i <arr.length; i++){ //0——arr.length-1
            //对arr中第i个位置的元素进行匹配, 0~i-1的元素已经有序
            int minIndex = i;
            for (int j = i; j <arr.length; j++){
                //0~i-1的元素已经排好序了
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    SortingHelper.swap(arr, j, minIndex);
                }
            }
        }
    }






    public static<E extends Comparable<E>> void sort2(E[] arr){
        for (int i = 0; i <arr.length; i++){
            int minIndex = i;
            int smaller = i;
            for (int j = i; j <arr.length; j++){
                if (arr[j].compareTo(arr[smaller]) < 0){
                    smaller = j;
                }
            }
            SortingHelper.swap(arr, minIndex, smaller);
        }
    }

    public static<E extends Comparable<E>> void sortReverse(E[] arr){
        for (int i = arr.length-1; i >= 0; i--){ //i=1  0——arr.length-1
            int minIndex = i;
            for (int j = i; j >= 0; j--){ //j=1, j=0
                if (arr[j].compareTo(arr[i]) < 0){
                    SortingHelper.swap(arr,minIndex,j);
                }
            }
        }
    }



    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("SelectionSort",arr);
        SortingHelper.sortTest("SelectionSort2",arr2);
    }
}
