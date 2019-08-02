class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) return true;
        long start = 1;
        long end = num + 1;
        long target = num;
        while (start < end) {
            // trick - this could be overflow
            long mid = start + (end - start) / 2;
            long value = mid * mid;
            if (value == target) { 
                System.out.println(mid);
                return true;
            }
            if (value > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
