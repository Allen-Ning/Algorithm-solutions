class Solution {
  public int candy(int[] ratings) {
    int[] values = new int[ratings.length];
    Arrays.fill(values, 1);
    
    // check left point of current point
    for (int i = 1; i < values.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        values[i] = values[i - 1] + 1;
      }
    }

    // check right point of current point
    for (int i = values.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        values[i] = Math.max(values[i], values[i + 1] + 1);
      }
    }
    
    int total = 0;
    for (int value : values) {
      total +=  value;
    }
    return total;
  }
}
