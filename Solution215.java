class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> list = new PriorityQueue();
        for (int num: nums) {
            list.offer(num);

            if (list.size() > k) {
                list.poll();
            }
        }
        return list.poll();
    }
}
