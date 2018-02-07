public class Deduplication {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isAdded = set.add(nums[i]);
            while (i < nums.length - 1 && !isAdded) {
                i++;
                isAdded = set.add(nums[i]);
            }
            if (isAdded) {
                nums[index] = nums[i];
                index++;
            }
        }
        if (set.add(nums[nums.length - 1])) {
            nums[index] = nums[nums.length - 1];
            index++;
        }
        return index;
    }
}