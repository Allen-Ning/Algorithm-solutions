class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int start = 0;
        int end = n - 1;
        int value = 1;

        // trick -> when n % 2 == 0 && start > end, it will stop.
        //          when n % 2 == 1 && start == end, it will stop. Zero is automatically in the middle
        while (start < end) {
            result[start++] = value;
            result[end--] = -value;
            value++;
        }

        return result;
    }
}