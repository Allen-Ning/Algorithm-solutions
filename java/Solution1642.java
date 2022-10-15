class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int prev = heights[0];
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 1; i < heights.length; i++) {
            int current = heights[i];
            if (current <= prev) {
                prev = current;
                continue;
            }

            queue.offer(current - prev);
            if (queue.size() <= ladders) {
                // trick -> guard function also needs to do prev = current
                prev = current;
                continue;
            }

            Integer min = queue.poll();
            if (bricks < min) return i - 1;

            bricks -= min;
            prev = current;
        }
        return heights.length - 1;
    }
}