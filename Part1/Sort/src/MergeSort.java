import java.util.Arrays;

public class MergeSort<E extends Comparable<E>> {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        //提前创建公共的temp数组，该数组有无元素不影响
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort2(arr, 0, arr.length - 1, temp);
    }

    //自底向上实现归并排序, 非递归调用，运行速度相对更快一些
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        //提前创建公共的temp数组
        E[] temp = Arrays.copyOf(arr, arr.length);
        //对区间长度进行合并
        for (int sz = 1; sz < arr.length; sz += sz) {
            //对区间内的元素进行merge  [i,i+size-1], [i+size, i+size+size-1]
            //i+size，即右区间最多到arr.length-1, 需要合并的区间的总长度为i+size+size
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge2(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, arr.length - 1), temp);
                }
            }
        }
    }

    //递归排序，不需要有返回值
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        //边界条件
        if (l >= r) {
            return;
        }

        //如果区间长度小于15，则调用插入排序(区间越小，元素有序的可能性越大，插入排序对有序元素的复杂度为O(n))
//        if(r - l <=15){
//            InsertSort.sort2(arr,l,r);
//        }
//        int mid = (l + r) / 2; 如果l和r都很大，可能会导致越界
        int mid = l + (r - l) / 2; //l , r-l 都小于r，肯定不会越界
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            //核心
            merge(arr, l, mid, r);
        }

    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1); //将原arr数组中的l~r部分拷贝到temp，注意temp中的索引从0开始temp[0~r-l]
        int i = l;
        int j = mid + 1;
        //k代表arr中的真实索引
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                //左侧已经排序完毕
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                //右侧已经排序完毕
                arr[k] = temp[i - l];
                i++;
            } else {
                //左右侧都还没有排序完毕
                if ((temp[i - l].compareTo(temp[j - l])) <= 0) {
                    arr[k] = temp[i - l];
                    i++;
                } else {
                    arr[k] = temp[j - l];
                    j++;
                }
            }
        }
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r, E[] temp) {
        //边界条件
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2; //l , r-l 都小于r，肯定不会越界
        sort2(arr, l, mid, temp);
        sort2(arr, mid + 1, r, temp);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            //核心
            merge2(arr, l, mid, r, temp);
        }

    }

    private static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r, E[] temp) {

        //使用公共的temp数组, 将arr从l开始长度为r-l+1的元素拷贝到temp中从l开始的地方, 下文不需要再减去偏移量了
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        //k代表arr中的真实索引
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                //左区间已经排序完毕，只需要将右区间的元素挨个放入arr中即可
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                //右区间已经排序完毕，只需要将左区间的元素挨个放入arr中即可
                arr[k] = temp[i];
                i++;
            } else {
                //左右侧都还没有排序完毕
                if ((temp[i].compareTo(temp[j])) <= 0) {
                    arr[k] = temp[i];
                    i++;
                } else {
                    arr[k] = temp[j];
                    j++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        System.out.println("Random array: ");
        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSort2", arr2);
        SortingHelper.sortTest("MergeSortBU", arr3);
    }
}
