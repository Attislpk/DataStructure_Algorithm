package 查找表;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 */
public class _219_存在重复元素_II {
}


class Solution219 {
    //使用查找表+滑动窗口，固定滑动窗口的大小为K，将窗口的右一个元素与窗口中的元素进行查找，如果有则返回true，否则返回false
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //定义查找表，此处不需要用到频率相关，因此定义一个Hashset
        Set<Integer> record = new HashSet<>();
        //定义窗口的右边界r,最大左边界通过r-k来确定 [r-k,r],一共有r-(r-k)+1=k+1个元素
        for(int r = 0; r < nums.length; r++){
            //先查找，如果没有就添加进查找表
            if(record.contains(nums[r])){
                return true;
            }
            //如果第r个元素在record中没有就添加进去，并且窗口右滑动
            record.add(nums[r]);
            //当窗口的长度达到K+1时，左右边界的距离为k,开始对左边界进行滑动
            if(record.size() == k + 1){
                record.remove(nums[r-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //定义查找表，该表中的元素需要按照顺序进行排序，因此定义一个TreeSet
        TreeSet<Long> record = new TreeSet<>();
        for(int r = 0; r < nums.length; r++){
            Long low = record.ceiling((long)nums[r] - t);
            //如果record中存在这个数，且满足大小条件
            if (low != null && low <= (long)nums[r] + t){
                return true;
            }
            //如果第r个元素在record中没有就添加进去，并且窗口右滑动
            record.add((long) nums[r]);
            //当窗口的长度达到K+1时，左右边界的距离为k,开始对左边界进行滑动
            if(record.size() == k + 1){
                record.remove((long)nums[r-k]);
            }
        }
        return false;
    }
}
