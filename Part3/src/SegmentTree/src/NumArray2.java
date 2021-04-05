public class NumArray2 {
    //使用sum[i]完成前i个元素的和，sum[i] = nums[0] + nums[1]+...+nums[i-1];
    //sum[0]=0, sum[1]=nums[0], sum[2]=sum[1]+nums[1]=nums[0]+nums[1],sum[3]=nums[0]+nums[1]+nums[2]=sum[2]+nums[2];
    private int[] sum;
    public NumArray2(int[] nums) {
         sum= new int[nums.length+1]; //包括sum[0]
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        //sum[j+1]=sum[j]+nums[j]包括nums[j], sum[i]=sum[i-1]+nums[i-1],排除nums[i];
        return sum[j+1]-sum[i];
    }
}
