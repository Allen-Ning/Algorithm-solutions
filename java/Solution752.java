class Solution {
  public int openLock(String[] deadends, String target) {
    String start = "0000";

    HashSet<String> checked = new HashSet();
    for (String deadend: deadends) checked.add(deadend);

    Queue<String> queue = new LinkedList();
    if (!checked.contains(start)) queue.offer(start);

    int step = 0;
    String next = "";
    while (queue.size() > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String current = queue.poll();
        StringBuilder sb = null;
        for (int x = 0; x < 4; x++) {
          sb = new StringBuilder(current);
          char c = sb.charAt(x);
          char newChar = (char) (c + 1);
          if (createNext(sb, x, newChar, queue, checked, target)) return step + 1;

          sb = new StringBuilder(current);
          newChar = (char) (c - 1);
          if (createNext(sb, x, newChar, queue, checked, target)) return step + 1;
        }
      }
      step++;
    }
    return - 1;
  }

  private boolean createNext(StringBuilder sb, int index, char newChar, Queue<String> queue,  HashSet<String> checked, String target) {
    if (newChar > '9') newChar = '0';
    if (newChar < '0') newChar = '9';
    sb.setCharAt(index, (char) newChar);
    String next = sb.toString();
    if (!checked.contains(next)) {
      queue.offer(next);
      checked.add(next);
      if (target.equals(next)) return true;
    }
    return false;
  }
}
