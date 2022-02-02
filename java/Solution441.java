class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) return 1;

        long start = 0;
        long end = n;
        long mid = 0;
        while (start + 1 != end) {
            mid = start + (end - start) / 2;
            if ((mid + 1) * mid / 2 < n) {
                start = mid;
            } else if ((mid + 1) * mid / 2 == n) {
                return (int) mid;   
            } else {
                end = mid;
            }
        }
        return (int)(start);
    }
}