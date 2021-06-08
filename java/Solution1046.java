class Solution {
    public int lastStoneWeight(int[] stones) {
      if (stones == null || stones.length == 0) return 0;
      Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
      for (int i = 0; i < stones.length; i++) queue.offer(stones[i]);

      while (queue.size() >= 2) {
        int stone1 = queue.poll();
        int stone2 = queue.poll();
        if (stone1 > stone2) queue.offer(stone1 - stone2);
      }

      if (queue.size() == 0) {
        return 0;
      } else {
        return queue.poll();
      }
    }
}
