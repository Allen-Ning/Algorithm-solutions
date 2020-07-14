class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // trick -> we need use b[1] - a[1] to keep the biggest num to be inserted, and then we can use smaller ones to update it
        //          e.g [1, 2] (6, 5, 4) -> [1, 2, 6] -> [1, 5, 6] -> [1, 4, 6] -> array only increasing one num
        //          otherwise a[1] - b[1] to keep the smallest ones in front, which will be causing issue due to
        //          adding multiple values. such as [1, 2]  (4, 5, 6) ->  [1, 2, 4, 5, 6] -> array increseing 3 nums
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
        int size = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int value = envelopes[i][1];
            // trick -> we will always keep [0, size) increasing order
            int index = binarySearch(dp, 0, size, value);
            dp[index] = value;
            if (index == size) size++;
        }
        return size;
    }

    private int binarySearch(int[] dp, int start, int end, int value) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] >= value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
