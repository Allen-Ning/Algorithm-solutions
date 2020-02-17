class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
      Stack<int[]> stack = new Stack();
      int[] results = new int[n];
      int overlapTime = 0;

      for (String log : logs) {
        String[] info = log.split(":");
        int id = Integer.parseInt(info[0]);
        String direction = info[1];
        int time = Integer.parseInt(info[2]);

        if (stack.size() == 0) overlapTime = 0;

        if (direction.equals("start")) {
          stack.push(new int[] {id, time });
        } else if (direction.equals("end")) {
          int[] start = stack.pop();
          int value = time - start[1]  + 1;
          results[id] += value;
          // trick -> this is the most tricky process
          //          this is for remove the overlap part
          //          e.g. process 0 needs to remove process 1 time in advance
          if (stack.size() > 0) results[stack.peek()[0]] -= value;
        }
      }
      return results;
    }
}
