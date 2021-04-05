//二分查找法的递归实现

public class BinarySearch {

    private BinarySearch() {
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //首先判断找到的情况，找到之后就不用继续判断了~，否则要判断很多没找到的情
            if (target.compareTo(data[mid]) == 0) {
                return mid;
            }
            if (target.compareTo(data[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
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


    //寻找>target的最小值
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        int l = 0;
        int r = arr.length; //如果比r还大，则取到arr.length，代表实际上不存在
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) <= 0) {
                //mid比target小，取右区间
                l = mid + 1; //mid 没用了
            } else {
                //mid>target
                r = mid;// mid还能用
            }
        }
        return l; //r  l = r  夹逼准则
    }

    //寻找<target的最大值
    public static <E extends Comparable<E>> int lower(E[] arr, E target) {
        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            System.out.println(l + "" + r);
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
