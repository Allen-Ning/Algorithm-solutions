class Solution {
    public int largestAltitude(int[] gain) {
        // loop
        int current = 0;
        int max = 0;

        for (int num : gain) {
            current += num;
            max = Math.max(current, max);
        }
        return max;
    }
}