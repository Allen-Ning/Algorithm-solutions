class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, ArrayList<Integer>> hash = new HashMap();
    int[] indegree = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      int pre    = prerequisites[i][1];
      int target = prerequisites[i][0];

      indegree[target] += 1;
      ArrayList list = hash.get(pre);
      if (list == null) { 
        list = new ArrayList();
        hash.put(pre, list); 
      }
      list.add(target);
    }

    LinkedList<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.push(i);
      }
    }

    while (!queue.isEmpty()) {
      int pre = queue.poll();
      ArrayList<Integer> list = hash.get(pre);
      if (list != null) {
        for (int val : list) {
          indegree[val] -= 1;
          if (indegree[val] == 0) {
            queue.offer(val);
          }
        }
      }
    }

    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] != 0) return false;
    }

    return true;
  }
}
