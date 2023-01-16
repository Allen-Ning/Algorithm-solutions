class StockPrice {

    HashMap<Integer, Integer> values;
    PriorityQueue<int[]> max;
    PriorityQueue<int[]> min;
    int current;

    public StockPrice() {
        this.values = new HashMap();
        this.max = new PriorityQueue<>((p1, p2) -> p2[1] - p1[1]);
        this.min = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        this.current = -1;
    }

    public void update(int timestamp, int price) {
        values.put(timestamp, price);
        max.offer(new int[] { timestamp, price});
        min.offer(new int[] { timestamp, price});
        current = Math.max(current, timestamp);
    }

    public int current() {
        Integer price = values.get(current);
        if (price == null) return -1;
        return price;
    }

    public int maximum() {
        // trick -> check if max has been changed when maximum() is being called
        while (max.size() > 0) {
            int[] element = max.peek();
            if (element[1] == values.get(element[0])) return element[1];
            max.poll();
        }
        return -1;
    }

    public int minimum() {
        // trick -> check if max has been changed when minimum() is being called
        while (min.size() > 0) {
            int[] element = min.peek();
            if (element[1] == values.get(element[0])) return element[1];
            min.poll();
        }
        return -1;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */