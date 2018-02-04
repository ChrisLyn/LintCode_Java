class Pair {
    int sum, index;
    public Pair (int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}

public class SubarraySumClosest {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        if (nums.length == 1) {
            return res;
        }
        int sum = 0;
        Pair[] sums = new Pair[nums.length + 1];
        
        //calculate accumulative sum for 0...2, 0...3, 0...4
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = new Pair(sum + nums[i - 1], i);
            System.out.println(sums[i].index);
            sum = sums[i].sum;
        }
        
        //Sort sum in ascending order, for later subtraction
        Arrays.sort(sums, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        
        //Find minimum difference, which indicates the closest
        for (int i = 1; i < sums.length; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1; //Why plus 1?
                res[1] = temp[1];
            }
        }
        return res;
        
    }
}