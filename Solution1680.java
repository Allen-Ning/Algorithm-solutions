class Solution {
    public int concatenatedBinary(int n) {
        long mod = (int) Math.pow(10, 9) + 7;
        // trick -> we need long to avoid overflow cos n is [1, 10^5] far more than 32 bits integer
        long result = 0;
        for (int i = 1; i <= n; i++) {
            // trick -> log2(n) = Math.log10(n) / Math.log10(2)
            int left = (int) (Math.log(i) / Math.log(2)) + 1;
            result = (result << left) + i;
            result = result % mod;
        }
        return (int) result;
    }
}

