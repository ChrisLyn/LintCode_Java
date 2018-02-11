public class TwoSumClosest {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (start < end) {
            int newDiff = target - (nums[start] + nums[end]);
            System.out.println(newDiff);
            diff = Math.min(Math.abs(newDiff), diff);
            if (newDiff > 0) {
                start++;
            } else if (newDiff < 0) {
                end--;
            } else {
                return 0;
            }
        }
        return diff;
    }
}