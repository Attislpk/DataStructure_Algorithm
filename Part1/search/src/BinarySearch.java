//二分查找法的递归实现

public class BinarySearch {

    private BinarySearch() {
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {  //循环终止条件是: l > r,此时搜索区间[l,r]==>[r+1,r]，区间不存在，说明该target在区间中不存在，因此返回-1
            int mid = l + (r - l) / 2;
            if (target.compareTo(data[mid]) == 0) {
                return mid;  //如果存在，在该行代码处直接返回
            }
            if (target.compareTo(data[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1; //如果不存在则返回-1
    }


    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        //边界条件
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (target.compareTo(data[mid]) == 0) {
            return mid;
        }
        if (target.compareTo(data[mid]) < 0) {
            return searchR(data, l, mid - 1, target);
        }
        return searchR(data, mid + 1, r, target);
    }


    //寻找>target的最小值, 非等值查找，确保一定有解！
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        int l = 0;
        int r = arr.length; //确保arr中的每一个元素都有大于它的最小值，对于最后一个元素而言，大于它的最小值位于arr.length处
        while (l < r) {  //由于r可以取到arr.length,因此搜索区间是[l,r),因此循环终止条件为 l==r
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) <= 0) {
                l = mid + 1; // <=不满足要求，需要舍弃
            } else {
                //mid>target,大于满足要求，需要保留
                r = mid;
            }
        }
        return l; //while终止条件为 l==r,因此返回l/r等价
    }



    //寻找<target的最大值
    public static <E extends Comparable<E>> int lower(E[] arr, E target) {
        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            //当l==r时，会出现死循环，向上取整
            int mid = l + (r - l + 1) / 2;
            if (arr[mid].compareTo(target) >= 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static <E extends Comparable<E>> int ceil(E[] arr, E target) {
        int u = upper(arr, target);
        if (u - 1 >= 0 && arr[u - 1] == target) {
            return u - 1;
        }
        return u;
    }

    public static <E extends Comparable<E>> int lowerCeil(E[] arr, E target) {
        int u = upper(arr, target);
        while (u - 1 >= 0 && arr[u - 1] == target) {
            u = u - 1;
        }
        return u;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
//        for (int i = 0; i <= 6; i++) {
//            System.out.print(BinarySearch.ceil(arr, i) + " ");
//        }
//        System.out.println();
        System.out.println(BinarySearch.lower(arr, 2));
    }
}
