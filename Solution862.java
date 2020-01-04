class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) preSum[i] = preSum[i - 1] + A[i - 1];

        Deque<Integer> queue = new LinkedList();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            // trick -> keeping increasing order
            while (queue.size() > 0 && preSum[i] <= preSum[queue.getLast()]) queue.pollLast();
            
            // trick -> we can pop the first one cos the queue is increasing oder, we do not need to keep it
            while (queue.size() > 0 && preSum[i] - preSum[queue.getFirst()] >= K) {
                result = Math.min(result, i - queue.pollFirst());
            }
            
            queue.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
