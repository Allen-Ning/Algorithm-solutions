class Solution {
    // 1   -  9 -> 1 digit
    // 10  - 99 -> double digit
    // 100 -> 999 -> 3 digits
    // 1000 -> 9999 -> 4 digits
    // 1 * counter -> 9 * counter + 9 * (counter - 1) + 9 * 1
    public int findNthDigit(int n) {
        int counter = 1;
        int total = 0;
        long low = 1;
        long high = 9;
        if (n < 9) return n;
        while (n > (high - low + 1) * counter) {
            n -= (high - low + 1) * counter;
            low = low * 10;
            high = high * 10 + 9;
            counter++;
        }

        low--;
        String str = "";
        if (n % counter == 0) {
            low += n / counter;
            str = low + "";
            return str.charAt(str.length() - 1) - '0';
        } else {
            low += (n / counter + 1);
            str = low + "";
            return str.charAt(n % counter - 1) - '0';
        }
    }
}
