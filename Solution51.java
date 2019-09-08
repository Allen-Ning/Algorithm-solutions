class Solution {
  List<List<String>> results = new ArrayList();
  public List<List<String>> solveNQueens(int n) {
    helper(new int[n], 0);
    return null;
  }

  private void helper(int[] queens, int current) {
    // enough number
    if (current >= n) {
      List<String> result = generateResult(queens);
      results.add(result);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!canPlace(queens, current, i)) continue;
      queendds[current] = i;
      helper(queens, current + 1);
    }
  }

  private boolean canPlace(int[] queens, int current, int position) {
    boolean checkTopLeft = false;
    int total = current;
    int currentX = current;
    // check top
    int currentY = position;
    // check leftTop
    int currentLeftY = position;
    // check rirghtTop
    int currentRightY = position;

    while (total > 0) {
      currentX--;
      total--;
      if (queens[currentX] == --currentLeftY ||
          queens[currentX] == currentY ||
          queens[currentX] == ++currentY) return false;
    }
    return true;
  }

  private List<String> generateResult(int[] queens) {
    return null; 
  }
}
