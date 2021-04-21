package 剑指;

public class 剑指Offer11旋转数组的最小数字 {
}

class Solution11 {
    //1,原始做法，遍历一次找到最小值，O(N)，没有用到题目给定的递增排序条件
    //2,联想到波谷数的求法，使用二分，O(logN)
    public int minArray(int[] numbers) {
       int left = 0;
       int right = numbers.length - 1;
       while (left < right) {
           int mid = left + ((right - left) >> 1);
           //此时numbers[mid]一定大于最小值，可以排除掉
           if (numbers[mid] > numbers[right]) left = mid + 1;
           //此时numbers[mid]可能是最小值，不能排除
           else if (numbers[mid] < numbers[right]) right = mid;
           //无法判断需要排除的区间，只能缩小区间
           else right --;
       }
        return numbers[left];
    }
}