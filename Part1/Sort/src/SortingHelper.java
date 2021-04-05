public class SortingHelper {


    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) { //arr[i] > arr[i+1]
                return false;
            }
        }
        return true;
    }

    //内部方法,在静态方法中只能调用静态方法
    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> void sortTest(String name, E[] arr) {
        long startTime = System.nanoTime();
        if (name.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        } else if (name.equals("InsertSort")) {
            InsertSort.sort(arr);
        }else if (name.equals("SelectionSort2")) {
            SelectionSort.sort2(arr);
        }else if (name.equals("MergeSort")) {
            MergeSort.sort(arr);
        } else if (name.equals("MergeSort2")) {
            MergeSort.sort2(arr);
        } else if (name.equals("MergeSortBU")) {
            MergeSort.sortBU(arr);
        } else if (name.equals("QuickSort")) {
            QuickSort.sort(arr);
        } else if (name.equals("QuickSort2ways")) {
            QuickSort.sort2ways(arr);
        } else if (name.equals("QuickSort3ways")) {
            QuickSort.sort3ways(arr);
        }else if (name.equals("BubbleSort")) {
            BubbleSort.sort(arr);
        }else if (name.equals("BubbleSort2")) {
            BubbleSort.sort2(arr);
        }else if (name.equals("ShellSort")) {
            ShellSort.sort(arr);
        }else if (name.equals("ShellSort2")) {
            ShellSort.sort2(arr);
        }else if (name.equals("ShellSort3")) {
            ShellSort.sort3(arr);
        }
        long endTime = System.nanoTime();
        double totaltime = (endTime - startTime) / 1000000000.0;
        if (!isSorted(arr)) {
            throw new RuntimeException(name + " failed!");
        }
        System.out.println(String.format("%s, n = %d, %f s", name, arr.length, totaltime));
    }
}
