class Solution {
  public boolean judgePoint24(int[] nums) {
    double[] values = new double[nums.length];
    for (int i = 0; i < values.length; i++) values[i] = nums[i];
    return helper(values);
  }

  private boolean helper(double[] values) {
    if (values.length == 1 && Math.abs(values[0] - 24) < 0.001 ) return true;
    if (values.length == 1 && Math.abs(values[0] - 24) >= 0.001) return false;

    boolean result = false;
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values.length; j++) {
        if (i == j) continue;

        double[] next = new double[values.length - 1];
        int index = 0;
        for (int z = 0; z < values.length; z++) {
            if (z == i || z == j) continue;
            next[index++] = values[z];
        }
        for (double mergeValue : getMergedValues(values[i], values[j])) {
          next[next.length - 1] = mergeValue;
          result = result || helper(next);
          if (result) return true;
        }
      }
    }
    return result;
  }

  private double[] getMergedValues(double value1, double value2) {
    return new double[] {value1 + value2, value1 - value2, value1 * value2, value1 / value2};
  }
}
