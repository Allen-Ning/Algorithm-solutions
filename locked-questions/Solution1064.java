class Solution {
    public int fixedPoint(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                // trick -> return the smallest index i that satisfies arr[i] == i
                if (arr[mid] == mid) result = mid;
                end = mid - 1;
            }
        }
        return result;
    }
}