// find 5
// In conclusion, 125 needs to be counted 3 times, 5 for first 5. 25 for second 5, 125 for third 5
// first time - find 5 -> count 1 -> count 1 like 5
// second time - find 5 * 5 -> count 2 -> count 2 like 25
// third time - find 5 * 5 * 5 -> count 3 like 125
class Solution {
    public int trailingZeroes(int n) {
        long i = 5;
        long result = 0;
        while (n >= i) {
            result += n / i;
            i *= 5;
        }
        return (int)result;
    }
}
