public class SubarraySum {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int start = 0;
        while (start < nums.length) {
            int sum = 0;
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
                if (sum == 0) {
                    list.add(start);
                    list.add(i);
                    break;
                }
            }
            if (sum == 0) {
                break;
            }
            start++;
        }
        return list;
    }
}