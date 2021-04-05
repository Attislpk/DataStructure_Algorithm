public class _704_二分查找 {
}


class Solution704 {

    public static int search(int[] nums, int target){
        return search(nums,0,nums.length-1,target);
    }

    private static int search(int[] data, int l, int r, int target){
        //边界条件
        if (l > r){
            return -1;
        }

        int mid = l + (r-l)/2;
        if (target == data[mid]){
            return mid;
        }
        if (target < data[mid]){
            return search(data,l,mid-1,target);
        }
        return search(data,mid+1,r,target);
    }
}

