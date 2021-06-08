class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
      List<List<Integer>> results = new ArrayList();

      if (buildings == null || buildings.length == 0) return results;

      Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
      queue.offer(0);

      List<int[]> data = new ArrayList();
      for (int[] building : buildings) {
        data.add(new int[]{building[0], building[2]});
        data.add(new int[]{building[1], -building[2]});
      }
      Collections.sort(data, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);

      List<Integer> list = null;
      int prev = 0;
      for (int[] pair : data) {
        if (pair[1] > 0) {
            queue.offer(pair[1]);
        } else {
            queue.remove(-pair[1]);
        }

        // trick -> this is pretty much clear solution
        //          after the offer/remove operation done
        //          if peek value change, we can add the 
        //          current point into the result
        int current = queue.peek();
        if (current != prev) {
            list = new ArrayList();
            list.add(pair[0]);
            list.add(queue.peek());
            results.add(list);
            prev = current;
        }
      }
      return results;
    }
}
