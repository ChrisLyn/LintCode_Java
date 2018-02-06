public class TwoSumDesign {
    /*
     * @param number: An integer
     * @return: nothing
     */
    List<Integer> nums = new ArrayList<>();
    public void add(int number) {
        // write your code here
        // if (nums == null || nums.size() == 0) {
        //     nums.add(number);
        // }
        // for (int i = 0; i < nums.size(); i++) {
        //     if (nums.get(i) > number) {
        //         nums.add(i, number);
        //         return;
        //     }
        // }
        nums.add(number);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        Collections.sort(nums);
        if (nums == null || nums.size() == 0) {
            return false;
        }
        
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) == value) {
                return true;
            } else if (nums.get(i) + nums.get(j) > value) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}