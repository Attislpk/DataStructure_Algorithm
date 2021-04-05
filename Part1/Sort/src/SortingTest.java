import java.util.Arrays;

public class SortingTest {


    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("ShellSort",arr2);
        SortingHelper.sortTest("ShellSort2",arr3);
        SortingHelper.sortTest("ShellSort3",arr4);


    }
}
