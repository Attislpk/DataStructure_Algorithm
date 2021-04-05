package 数组;

public class _75颜色分类_ {
}

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0,1 和 2 分别表示红色、白色和蓝色。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class Solution75 {
    /**
     * 扫描计数, 时间复杂度O(n),空间复杂度O(k),k为新开数组的元素个数
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++){
        }
        for (int num : nums) {
            assert num>=0 && num <=2;
            count[num]++;
        }
       //count中存放的是每个元素的个数
        int index = 0; //记录位置
        for(int i = 0; i < count[0]; i++){
            nums[index++] = 0;
        }
        for(int i = 0; i < count[1]; i++){
            nums[index++] = 1;
        }
        for(int i = 0; i < count[2]; i++){
            nums[index++] = 2;
        }
    }

    /**
     * 利用三路快排的思想
     * []
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        //[0,zero],[zero+1,i-1],i代表当前需要判断的元素,[未排序元素],[two,length-1]
        int zero = -1;
        int two = nums.length;
        for(int i = 0; i < two;){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 0){
                zero ++;
                swap(nums,zero,i);
                i++;
            }else {
                assert nums[i] == 2;
                two--;
                swap(nums,i,two);
            }
        }
    }

    //传入nums数组的引用, 交换i,j位置的元素
    static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,0,2,1,1,0};
        sortColors2(test);
    }
}