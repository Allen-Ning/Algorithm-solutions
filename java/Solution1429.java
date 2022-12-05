class FirstUnique {
    private Queue<Integer> queue;
    private Map<Integer, Integer> map;

    public FirstUnique(int[] nums) {
        queue = new LinkedList();
        map = new HashMap();
        for (int num : nums) this.add(num);
    }

    public int showFirstUnique() {
        // trick -> this is working cos we will never remove element from queue
        while (queue.size() > 0 && map.get(queue.peek()) > 1) {
            queue.poll();
        }
        return queue.size() > 0 ? queue.peek() : -1;
    }

    public void add(int value) {
        queue.offer(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */