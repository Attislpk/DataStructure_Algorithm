package 剑指.二分查找;

class 剑指Offer11旋转数组的最小数字 {
}

class Solution11 {
    //1,原始做法，遍历一次找到最小值，O(N)，没有用到题目给定的递增排序条件
    //2,联想到波谷数的求法，使用二分，O(logN)
    public int minArray(int[] numbers) {
        //多情况下的二分查找法,最小值一定存在, 因此一定要返回最小值
        int l = 0;
        int r = numbers.length -1;
        while (l < r) { //当l==r时，区间长度为1，说明夹逼已经找到了最小值，此时退出循环
            int mid = l + (r - l )/ 2;
            if (numbers[mid] > numbers[r]) l = mid + 1;
            else if (numbers[mid] < numbers[r]) r = mid;
            //不确定需要舍弃的区间，只能缩小区间,且此时nums[mid]==nums[r],不用担心最小值会被舍弃
            else r--;
        }
        //最小值一定存在，循环退出条件为l == r, 由于在while循环中没有返回值，因此最后的返回值在return这里
        // 此处有疑惑，因为退出条件如果是l>=r，则l==r+1时退出，不存在夹逼，因此需要修改退出条件
        return numbers[l];
    }
}