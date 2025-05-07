class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) set.add(num);

        int result = 0;
        // trick -> loop through the set not original array to reduce time
        for (int num : set) {
            // trick -> this is only find the low boundary of the sequence
            //          given there is no need to find both low boudary and high boundray
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