
//递归函数求数组和
public class SUM {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr, int l){
        //边界条件
        if (l==arr.length){
            return 0;
        }
        //递归过程, 将原过程转换为更小的等价过程
        return arr[l] + sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(sum(arr));
    }

}
