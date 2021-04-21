package 二分;

public class _69_x的平方根 {
}

class Solution69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid == x / mid) return mid;
            else if (mid < x / mid) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}