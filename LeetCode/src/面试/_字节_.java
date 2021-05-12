package 面试;

public class _字节_ {

    /**
     *   使用二分查找实现平方根函数，要求精确到小数点后6位
     */
    public float sqrt_search(float n){
        float mid = 0.0f;
        if(n < -1e-6){
            // 小于0，抛异常
            throw new IllegalArgumentException();
        }else if(Math.abs(n) >= -1e-6 && Math.abs(n) <= 1e-6){
            return mid;
        }else{
            // 逐次逼近，默认平方根的不会超过n的一半
            float high = n / 2.0f;
            float low = 0.0f;
            while(Math.abs(high - low) > 1e-6){
                // 首先找到中间值
                mid = low + (high - low) / 2;
                float tmp = mid * mid;
                // 比较并更新 high和low
                if((tmp - n) > 1e-6){
                    high = mid;
                }else if((tmp -n) < -1e-6){
                    low = mid;
                }else{
                    return mid;
                }
            }
        }
        return mid;
    }
}

class bogu {
    public static void main(String[] args) {
       int[] arr = new int[] {9,8,3,4,6,2,7,9};
        System.out.println(search(arr));
    }
    private static int search(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) { //因为right是arr.length-1,因此此处可以取=
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
                return mid;
            }else if (arr[mid] > arr[mid-1]) {
                //left区间满足条件, 但是由于mid不满足要求，所以要把mid排除
                right = mid - 1;
            }else left = mid + 1;
        }
        return -1;
    }
}


