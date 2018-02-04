public class MaxSubArray {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}