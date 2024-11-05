class Solution {
    public double myPow(double x, int n) {
        if (n < 0) x = 1 / x;
        return helper(x, Math.abs((long) n));
    }

    // trick -> the core idea is to use n / 2 to reduce the number of recursion
    //        e.g. x ^ 10 = (x ^ 2) ^ 5
    //                      ((x ^ 2) ^ 2 ) * x
    //             x ^ 8 =  (x ^ 2) ^ 4
    //                      ((x ^ 2) ^ 2) ^ 2)
    private double helper(double base, long n) {
        if (n == 0) return 1;
        if (n == 1) return base;

        double result = helper(base * base, n / 2);
        if (n % 2 == 1) result *= base;
        return result;
    }
}