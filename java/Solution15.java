class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums[i] + nums[j] + nums[k] == 0
        // i != j, i !=k, j !=k
        // Notice that the solution set must not contain duplicate triplets.

        /** brute-force solution o(n^3)
            HashSet<String> -> record result
            for (i) {
                for (j) {
                    for (k) {
                        if (condition and not duplicated) add results;
                    }
                }
            }
         */

        /**
            Sort nlog(n)
                 [-1, 0, 1, 2, -1, -4]
        step1    [-4, -1,-1,0, 1,  2]
        step2    fix one value, search the sum of the other
                   |   a           b
                 [-4, -1,-1,0, 1,  2]

                       |         a  b
                 [-4, -1,-1, -1, 0, 1,  2 , 2]
         */
        // step1
        Arrays.sort(nums);

        // step2
        List<List<Integer>> results = new ArrayList();
        for (int i = 0; i < nums.length - 1; i++) {
            // trick -> dedupe
            //          original: [-1, 0, 1, 2, -1, -4]
            //          sort:     [-4,-1,-1, 0,  1,  2]
            //          this is to avoid [-1,0,1] and -1 is from index 1
            //                           [-1,0,1] and -1 is from index 2
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int lookup = nums[i] * -1;

            int j = i + 1;
            int z = nums.length - 1;
            while (j < z) {
                if (nums[j] + nums[z] > lookup) {
                    z--;
                } else if (nums[j] + nums[z] < lookup) {
                    j++;
                } else {
                    List<Integer> result = new ArrayList();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[z]);
                    results.add(result);

                    int preValue = nums[j];

                    j++;
                    z--;

                    // trick -> this is to avoid duplicated
                    //          move j to the next available
                    //          also no need to move z given j is moved
                    //          and the the current matched z will not match anymore
                    //          original: [-1, 0, 1, 2, 0, 1]
                    //          sort:     [-1, 0, 0, 1, 1, 2]
                    //          this is to avoid: [-1, 0, 1] 0 is from index 1
                    //                            and 1 is from index 4 from
                    //                            the sorted array
                    while (j < nums.length && nums[j] == preValue) {
                        j++;
                    }
                }
            }
        }
        return results;
    }
}