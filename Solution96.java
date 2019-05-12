class Solution {
  public int numTrees(int n) {
    if (n == 1) return 1;
    int[] states = new int[n + 1];
    states[0] = 1;
    states[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        states[i] += (states[j] * states[i - j - 1]);
      }
    }
    return states[n];
  }
}
