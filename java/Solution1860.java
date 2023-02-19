class Solution {
    public int[][] highFive(int[][] items) {
        // HashMap with PQ
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            PriorityQueue<Integer> pq = map.getOrDefault(id, new PriorityQueue<Integer>((num1, num2) -> num1 - num2));
            pq.offer(score);
            if (pq.size() > 5) pq.poll();

            map.put(id, pq);
        }

        int[][] results = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            Integer id = entry.getKey();
            PriorityQueue<Integer> values = entry.getValue();

            int totalScore = 0;
            int size = values.size();
            while (values.size() > 0) {
                totalScore += values.poll();
            }

            int averageScore = totalScore / size;
            results[index++] = new int[] {id, averageScore};
        }

        return results;
    }
}