class Solution {
    public int maxLength(int[] ribbons, int k) {
        int max = findMax(ribbons);
        return binarySearch(ribbons, 1, max + 1, k);
    }

    private int binarySearch(int[] ribbons, int l, int h, int k) {
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (calc(ribbons, k, mid)) {
                l = mid + 1;
            } else {
                h = mid
            }
        }
        // trick -> l is the last valid result
        return l - 1;
    }

    private boolean calc(int[] ribbons, int k, int length) {
        int counter = 0;
        for (int ribbon : ribbons) {
            counter += ribbon / length;
            if (counter >= k) return true;
        }
        return false;
    }

    private int findMax(int[] ribbons) {
        int max = -1;
        for (int ribbon : ribbons) max = Math.max(ribbon, max);
        return max;
    }
}