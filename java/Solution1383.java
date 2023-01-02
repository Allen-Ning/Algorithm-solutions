class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Element[] data = new Element[n];
        for (int i = 0; i < n; i++) data[i] = new Element(speed[i], efficiency[i]);

        Arrays.sort(data, (e1, e2) -> e2.efficiency - e1.efficiency);
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e1.speed - e2.speed);

        int mod = (int)(1e9 + 7);
        long speedSum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() >= k) speedSum -= pq.poll().speed;

            speedSum += data[i].speed;
            max = Math.max(max, (speedSum * data[i].efficiency));
            pq.offer(data[i]);
        }
        return (int) (max % mod);
    }

    class Element {
        int speed;
        int efficiency;

        public Element(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
}