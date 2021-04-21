package 排序算法;
public class MergeSort {
    public static void merge(int[] arr) {
        if (arr == null || arr.length < 2)return;

        //process(arr, 0, arr.length - 1);
        process2(arr, 0, arr.length - 1);
    }

    private static void process (int[] arr, int L, int R) {
        //terminator 区间长度为1
        if (L == R) return;
        //不要吝惜括号！！
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);

        //判断是否需要merge
        if (arr[mid] <= arr[mid+1]) return;
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) help[i++] = arr[p1++];
        while (p2 <= R) help[i++] = arr[p2++];
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    private static void process2(int[] arr, int L, int R) {
        if (0 == R) return;
        int mergeSize = 1;
        int len = arr.length;
        while (mergeSize < len) {
            int start = 0;
            while (start < len) {
                //mid - L = size - 1  区间长度=元素个数-1
                int mid = mergeSize + start - 1;
                if (mid >= len) break;
                //R - (mid+1) = size - 1  区间长度=元素个数-1
                int end = Math.min(len - 1, mid + mergeSize);
                merge(arr, start, mid, end);
                //继续归并下一个区间
                start = end + 1;
            }
            if (mergeSize > len / 2) break; //避免溢出
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1,6,7,1,2,3};
        merge(arr);
        for (int i: arr) {
            System.out.println(i);
        }
    }
}
