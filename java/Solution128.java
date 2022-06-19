class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) set.add(num);

        int result = 0;
        for (int num : set) {
            if (set.contains(num - 1)) continue;    

            int low = num;
            int high = num;
            // trick -> if there is duplicated num, only count 1 time
            //         e.g. input: [1, 2, 2, 3, 4, 5]
            //              output: 5 [1, 2, 3, 4, 5]
            while (set.contains(high + 1)) {
                high += 1;
            }

            result = Math.max(result, high - low + 1);
        }
        return result;
    }
}