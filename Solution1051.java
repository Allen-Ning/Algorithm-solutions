class Solution {
    public int heightChecker(int[] heights) {
        int[] counters = new int[101];
        for (int height : heights) counters[height] += 1;

        int current = 1;
        int result = 0;
        for (int height : heights) {
            while (counters[current] == 0) current++;
            if (height != current) result++;
            counters[current] -= 1;
        }
        return result;
    }
}
