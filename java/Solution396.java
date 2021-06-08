import java.lang.Math;

class Solution {
  public int maxRotateFunction(int[] A) {
    int sum = 0;
    int iterator = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      iterator += A[i] * i;
    }

    int result = iterator;
    for (int i = 1; i < A.length - 1; i++) {
      iterator =  iterator - sum + A.length * A[i - 1];
      result = Math.max(iterator, result);
    }
    return result;
  }
}
