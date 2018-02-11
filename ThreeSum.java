public class ThreeSum {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (0 == nums[start] + nums[end] + nums[i]) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[start]);
                        solution.add(nums[end]);
                        list.add(solution);
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[start] + nums[end] + nums[i] > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return list;
    }
}