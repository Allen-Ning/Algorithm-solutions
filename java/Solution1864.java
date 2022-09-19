class Solution {
    public int minSwaps(String s) {
        int total = 0;
        int missOne = 0;
        int missZero = 0;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') total += 1;
            if (c == '0') total -= 1;

            if (i % 2 == 0) {
                if (c == '0') missOne++;
                if (c == '1') missZero++;
            }
        }
        if (Math.abs(total) >= 2) return -1;

        if (total > 0) {
            return missOne;
        } else if (total == 0) {
            return Math.min(missZero, missOne);
        }else {
            return missZero;
        }
    }
}