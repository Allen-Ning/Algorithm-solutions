class Solution {
    public int[] countBits(int n) {
        // trick -> find example below
        // 0 --> 0
        // 1 --> 1
        // 2 --> 10
        // 3 --> 11
        // 4 --> 100
        // 5 --> 101
        // 6 --> 110
        // 7 --> 111
        // 8 --> 1000
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i / 2] + 1;
            }
        }
        return result;
    }
}