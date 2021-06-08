class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int[] result = mat[0];
        for (int i = 1; i < mat.length; i++) result = merge(result, mat[i], k);
        return result[k - 1]; 
    }

    private int[] merge(int[] row1, int[] row2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (row1[a[0]] + row2[a[1]]) - (row1[b[0]] + row2[b[1]]));
        for (int i = 0; i < row1.length; i++) {
            pq.offer(new int[] {i, 0});
            if (pq.size() == k) break;
        }

        int[] result = new int[k];
        int size = 0;
        while (pq.size() > 0 && size < k) {
            int[] element = pq.poll();
            result[size++] = row1[element[0]] + row2[element[1]];
            if (element[1] + 1 < row2.length) pq.offer(new int[] {element[0], element[1] + 1});
        }

        while (size < k) result[size++] = Integer.MAX_VALUE;
        return result;
    }
}