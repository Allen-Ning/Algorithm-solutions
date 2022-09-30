class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // trick -> syntax
        Deque<Integer> deque = new ArrayDeque();

        int[] results = new int[nums.length - k + 1];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            deque.add(i);

            // keep deque decreasing
            while (deque.size() > 0 && num >= nums[deque.getLast()]) deque.removeLast();

            // remove element if needed
            if (deque.size() > 0 && i - deque.getFirst() >= k) deque.removeFirst();

            // add the current element
            deque.addLast(i);

            // add to result
            if (i >= k - 1) results[counter++] = nums[deque.getFirst()];
        }
        return results;
    }
}