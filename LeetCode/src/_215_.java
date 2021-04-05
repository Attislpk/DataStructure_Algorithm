import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
//215. 数组中的第K个最大元素-- > 数组从大到小排序，取出第k个元素(最小堆排序后，k个元素中的第一个元素即为第k大的元素)
public class _215_ {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //java中的PriorityQueue使用最小堆实现
        for (int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++){
            if (!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();//移除pq中的最小元素
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}


//利用双路快速排序实现
class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return selectK(nums,0, nums.length-1,nums.length-k,random);
    }

    private int selectK(int[] nums, int l, int r, int k, Random random){

        int p = partition(nums,l,r,random); //对于nums数组进行分治之后返回的nums数组是有序的,如果标定点在数组中所处的位置刚好为k，则不需要继续分治
        if (k == p){
            return nums[p];
        }else if (k <p ){
            return selectK(nums,l,p-1,k,random);
        }else {
            return selectK(nums,p+1,r,k,random);
        }
    }

    //返回标定点的索引位置
    private int partition(int[] nums, int l, int r, Random random){
        int p = l+(random.nextInt(r-l+1));
        swap(nums,p,l);

        int i = l + 1;
        int j = r;
        while (true){
            while (i <= j && nums[i] < nums[l]){
                i++;
            }
            while (j >= i && nums[j] > nums[l]){
                j--;
            }

            if (i >= j) break;
            swap(nums,i,j);
            i++;
            j--;
        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//剑指Offer40
//剑指 Offer 40. 最小的k个数   https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

class Solution4 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[0];
        }
        Random random = new Random();
       selectK(arr, 0, arr.length - 1, k-1, random);// o~ k-1 共k个数
        //上述selectK执行完毕后，arr已经有序
        return Arrays.copyOf(arr,k);
    }

    //对arr进行排序
    private int selectK(int[] arr, int l, int r, int k, Random random) {
        int p = partition(arr, l, r, random);
        if (k == p) {
            return arr[p];
        } else if (k < p) {
            return selectK(arr, l, p - 1, k, random);
        } else {
            return selectK(arr, p + 1, r, k, random);
        }

    }

    //快排切分
    private int partition(int[] arr, int l ,int r, Random random){
        int p = l+(random.nextInt(r-l+1));
        swap(arr,l,p);

        int i = l +1;
        int j = r;
        //[l+1,i-1],[j+1,r]
        while (true){
            while ( i <= j && arr[i] < arr[l]){
                i++;
            }
            while ( j>= i && arr[j] > arr[l]){
                j--;
            }
            if (i>=j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

