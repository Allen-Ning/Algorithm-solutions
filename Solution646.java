class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int counter = 1;
        int[] pre = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            int[] current = pairs[i];
            if (current[0] <= pre[1]) continue;
            counter++;
            pre = current;
        }
        return counter;
    }
}
