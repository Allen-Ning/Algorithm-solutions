class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[1] - b[1] == 0 ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < mat.length; i++) {
            int counter = count(mat[i]);
            maxHeap.offer(new int[] {i, counter});
            if (maxHeap.size() > k) maxHeap.poll();
        }
        int[] results = new int[k];
        int index = k - 1;
        while (maxHeap.size() > 0) results[index--] = maxHeap.poll()[0];
        return results;
    }

    private int count(int[] nums) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            //  0 1 2 3 4
            // [1,1,0,0,0]
            if (nums[mid] == 0) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
