class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        while (start + 1 != end) {
            long mid = start + (end - start) / 2;
            long containers = (1 + mid) * mid / 2;

            if (containers < n) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // trick -> different result for complete and incomplete n
        //          when n is 5, return 2
        //          when n is 6, return 3
        long total = (1 + end) * end / 2;
        if (total > n) {
            return (int)end - 1;
        } else {
            return (int)end;
        }
    }
}