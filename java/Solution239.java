class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        Deque<Integer> q = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1 ) {
                q.pollFirst();
            }

            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }

            q.offer(i);
            if (i - k + 1 >= 0) result[i - k + 1] = nums[q.peekFirst()];
        }
        return result;
    }
}
