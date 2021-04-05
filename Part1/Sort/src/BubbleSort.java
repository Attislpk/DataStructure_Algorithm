public class BubbleSort {

    private BubbleSort(){}

    public static<E extends Comparable<E>> void sort(E[] arr){
        //对于n个元素，要进行n-1次排序
        for (int i = 0; i < arr.length-1;i++){
            for (int j = 0; j+1<= arr.length-1-i; j++){
                //j+1即待比较的最后一个元素，i是已经排好的元素个数
                if (arr[j].compareTo(arr[j+1])>0){
                    SortingHelper.swap(arr,j,j+1);
                }
            }
        }
    }

    public static<E extends Comparable<E>> void sort2(E[] arr){
        //对于n个元素，要进行n-1次排序
        for (int i = 0; i < arr.length-1;i++){
            //判断内层循环中是否有元素交换
            boolean isSwapped = false;
            for (int j = 0; j+1<= arr.length-1-i; j++){
                //j+1即待比较的最后一个元素，i是已经排好的元素个数
                if (arr[j].compareTo(arr[j+1])>0){
                    SortingHelper.swap(arr,j,j+1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public static<E extends Comparable<E>> void sort3(E[] arr){
        //对于n个元素，要进行n-1次排序, i代表已经排好序的元素个数(只要arr.length-1个元素有序，则剩下一个元素自然也是有序的)
        for (int i = 0; i < arr.length-1;){
            //最后一次交换的元素索引
            int lastSwappedIndex = 0;
            for (int j = 0; j+1<= arr.length-1-i; j++){
                //j+1即待比较的最后一个元素，i是已经排好的元素个数
                if (arr[j].compareTo(arr[j+1])>0){
                    SortingHelper.swap(arr,j,j+1);
                    lastSwappedIndex = j+1; //最后一次完成交换的索引位置
                }
            }
            //更新已经排好序的元素个数
            i = arr.length - lastSwappedIndex;
        }
    }
















    public static<E extends Comparable<E>> void mySort(E[] arr){
        //i的变化取决于一轮冒泡排序后lastSwappedIndex的大小, 此处的i只用作计数，没有其他含义
        for (int i = 0; i < arr.length -1;){
            //lastSwappedIndex代表最后一个进行交换的元素索引假设所有元素都排好序了，如果在一轮冒泡排序中，没有发生过元素的交换，则该假设成立
            int lastSwappedIndex = 0;
            for (int j = 0; j+1 <= arr.length-1-i;j++){
                if (arr[j].compareTo(arr[j+1])>0){
                    SortingHelper.swap(arr,j,j+1);
                    lastSwappedIndex=j+1;
                    //j+1以后的元素没有发生过交换，则j+1~n的元素已经是有序的，没有必要再对j+1以后的元素进行冒泡排序
                }
            }
            //此处的i只用作计数，没有其他含义
            i = arr.length-lastSwappedIndex;//i代表还未排好序的元素个数
        }
    }
}


