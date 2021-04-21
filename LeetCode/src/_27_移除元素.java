import java.util.ArrayList;
import java.util.Arrays;

public class _27_移除元素 {
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        //下一个不等的元素存放的位置
        int index = 0;
        for (int num: nums) {
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index; //0 ~ index-1 长度为index
    }
}