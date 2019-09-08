class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> results = new ArrayList();
    helper(new int[n], 0, results);
    return results;
  }

  private void helper(int[] queens, int current, List<List<String>> results) {
    if (current >= queens.length) {
      List<String> result = generateResult(queens);
      results.add(result);
      return;
    }

    for (int i = 0; i < queens.length; i++) {
      if (!canPlace(queens, current, i)) continue;
      queens[current] = i;
      helper(queens, current + 1, results);
    }
  }

  private boolean canPlace(int[] queens, int current, int position) {
    int total = current + 1;
    int currentX = current - 1;
    int currentY = position;

    // check leftTop
    int currentLeftY = position;
    // check rirghtTop
    int currentRightY = position;

    while (total > 0) {
      if (currentX < 0) return true;
      if (queens[currentX] == --currentLeftY ||
          queens[currentX] == currentY ||
          queens[currentX] == ++currentRightY) return false;
        total--;
        currentX--;
    }
    return true;
  }

  private List<String> generateResult(int[] queens) {
    List<String> list = new ArrayList();
    for (int i = 0; i < queens.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < queens.length; j++) {
            if (queens[i] == j) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        list.add(sb.toString());
    }
    return list;
  }
}
