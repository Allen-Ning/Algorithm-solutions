class Solution {
    public int subtractProductAndSum(int n) {
        int value = 1;
        int value2 = 0;
        while (n > 0) {
            int num = n % 10;
            value *= num;
            value2 += num;
            n /= 10;
        }
        return value - value2;
    }
}
