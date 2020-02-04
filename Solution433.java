class Solution {
    public int minMutation(String start, String end, String[] bank) {
      Set<String> set = new HashSet();
      for (String one : bank) set.add(one);
      Set<String> visited = new HashSet();
      Queue<String> queue = new LinkedList();
      queue.offer(start);

      String[] replacement = new String[] {"A", "C", "G", "T"};

      int step = 0;
      while(!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          String str = queue.poll();
          for (int j = 0; j < str.length(); j++) {
            for (String c : replacement) {
              String newStr = str.substring(0, j) + c + str.substring(j + 1);
              if (!set.contains(newStr)) continue;
              if (visited.add(newStr)) {
                queue.offer(newStr);
                if (newStr.equals(end)) return step + 1;
              }
            }
          }
        }
        step++;
      }
      return -1;
    }
}
