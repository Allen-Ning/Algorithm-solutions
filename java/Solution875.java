class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 0;
        int end = piles[0];
        for (int i = 1; i < piles.length; i++) {
            end = Math.max(piles[i], end);
        }
        end += 1;

        while (start + 1 != end) {
            int guess = start + (end - start) / 2;

            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                long each = piles[i] / guess;
                if (piles[i] % guess != 0) each += 1;
                hours += each;
            }

            // start                 end
            // 3, 4, 5, 6, 7 , 8, 8  xx
            if (hours > (long)h) {
                start = guess;
            } else {
                end = guess;
            }
        }
        return end;
    }
}
