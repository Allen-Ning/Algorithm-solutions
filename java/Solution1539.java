class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = -1;
        int h = arr.length;

        while (l + 1 != h) {
            int mid = l + (h - l) / 2;
            
            if (arr[mid] - mid - 1 < k) {
                l = mid;
            } else {
                h = mid;
            }
        }
        // trick -> simplify calculation
        //          arr[h] - 1 - (arr[h] - h - 1) + k -> h + k
        return h + k;
    }
}