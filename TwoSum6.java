public class TwoSum6 {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                count++;
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            } else {
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
        }
        return count;
    }
}