class Solution {
  public int totalNQueens(int n) {
    int[] results = new int[1];
    helper(new int[n], 0, results);
    return results[0];
  }

  private void helper(int[] queens, int current, int[] results) {
    if (current >= queens.length) {
      results[0]++;
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
}
