class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue(Collections.reverseOrder());
        large = new PriorityQueue();
    }
    
    public void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());
        if (large.size() < small.size()) {
            large.offer(small.poll());
        }
    }
    
    public double findMedian() {
        return large.size() == small.size() ? (large.peek() + small.peek())/2.0 : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
