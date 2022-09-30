class SORTracker {

    PriorityQueue<Pair> minHeap;
    PriorityQueue<Pair> maxHeap;

    public SORTracker() {
        this.maxHeap = new PriorityQueue<>((p1, p2) -> p1.score == p2.score ? p1.name.compareTo(p2.name) : p2.score - p1.score);
        this.minHeap = new PriorityQueue<>((p1, p2) -> p1.score == p2.score ? p2.name.compareTo(p1.name) : p1.score - p2.score);
    }

    public void add(String name, int score) {
        this.minHeap.add(new Pair(name, score));
        this.maxHeap.add(this.minHeap.poll());
    }

    public String get() {
        if (maxHeap.size() == 0) return "";

        Pair pair = maxHeap.poll();
        minHeap.add(pair);
        return pair.name;
    }

    class Pair {
        String name;
        int score;

        public Pair(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */