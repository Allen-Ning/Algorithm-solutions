class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0 || H == 0) return 0;

        int max = 0;
        for (int pile : piles) max = Math.max(max, pile);

        if (piles.length == H) {
            return max;
        } else if (piles.length > H) {
            return -1;
        } else {
            int l = 1;
            int r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (eatHours(piles, mid) > H) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    private int eatHours(int[] piles, int eatSpeed) {
        int hour = 0;
        for (int pile : piles) {
            if (pile <= eatSpeed) {
                hour += 1;
            } else {
                hour += (pile / eatSpeed + 1);
            }
        }
        return hour;
    }
}
