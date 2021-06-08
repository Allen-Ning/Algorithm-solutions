class Solution {
    public boolean isBipartite(int[][] graph) {
      if (graph == null || graph.length == 0) return false;

      int[] checked = new int[graph.length];
      Queue<int[]> queue = new LinkedList();
      // trick -> this outter loop is the the most tricky one
      //          In some scenario, some nodes migth not be reached
      //          we need to add them in and dye into one of the set (1 or -1)
      //          this will make sure all points have been checked after running
      for (int i = 0; i < graph.length; i++) {
        if (checked[i] != 0) continue;
        int sign = 1;
        queue.offer(graph[i]);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] nodes = queue.poll();
                for (int node : nodes) {
                    if (checked[node] == (sign * -1)) return false;
                    if (checked[node] == sign) continue;

                    checked[node] = sign;
                    queue.offer(graph[node]);
                }
            }
            sign = -1 * sign;
        }
      }
      return true;
    }
}
