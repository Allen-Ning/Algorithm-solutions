class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int current = 0;
    int lack = 0;
    int startIndex = 0;
    for (int i = 0; i < gas.length; i++) {
      current += gas[i] - cost[i];
      if (current < 0) {
        startIndex = i + 1;
        lack += current;
        current = 0;
      }
    }
    return (current + lack >= 0) ? startIndex : -1;
  }
}
