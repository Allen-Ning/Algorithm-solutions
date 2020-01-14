class Solution {
  public int slidingPuzzle(int[][] board) {
    String target = "123450";
    HashSet<String> set = new HashSet();
    Queue<String> queue = new LinkedList();

    // trick -> be careful about directly return
    if (target.equals(getStr(board))) return 0;

    queue.offer(getStr(board));

    // trick -> this trick will help us to swop the 0's with others number
    int[][] swops = new int[][] {
        {1, 3},
        {0, 2, 4},
        {1, 5},
        {0, 4},
        {1, 3, 5},
        {2, 4}
    };

    int step = 0;
    while (queue.size() > 0) {
      int size = queue.size();

      for (int index = 0; index < size; index++) {
        String current = queue.poll();
        for (int i = 0; i < swops.length; i++) {
            if (current.charAt(i) != '0') continue;
            for (int swopIndex : swops[i]) {
                StringBuilder sb = new StringBuilder(current);
                char c = sb.charAt(swopIndex);
                sb.setCharAt(swopIndex, '0');
                sb.setCharAt(i, c);

                String newStr = sb.toString();
                if (set.contains(newStr)) continue;
                set.add(newStr);
                queue.offer(newStr);
                if (newStr.equals(target)) return step + 1;
            }
        }
      }
      step++;
    }
    return -1;
  }

  private String getStr(int[][] board) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        sb.append(board[i][j]);
      }
    }
    return sb.toString();
  }
}
