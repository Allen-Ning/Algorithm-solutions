class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) return -1;

        int low = 0;
        int high = A.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
