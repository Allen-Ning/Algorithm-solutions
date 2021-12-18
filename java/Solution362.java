class HitCounter {
    int[] times;
    int[] timestamps;

    public HitCounter() {
        times = new int[300];
        timestamps = new int[300];
    }

    public void hit(int timestamp) {
        int index = (timestamp - 1) % 300;
        if (timestamp - 300 >= timestamps[index]) {
            times[index] = 1;
        } else {
            times[index] += 1;
        }
        timestamps[index] = timestamp;
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - timestamps[i] < 300) total += times[i];
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */