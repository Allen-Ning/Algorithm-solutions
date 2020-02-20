class Solution {
    public int longestOnes(int[] A, int K) {
      int l = 0;
      int r = 0;
      int counter0 = 0;
      int max = 0;
      while (l <= r && r < A.length) {
        if (A[r] == 0) counter0 += 1;

        while (counter0 > K) {
          if (A[l] == 0) counter0--;
          l++;
        }
        max = Math.max(max, r - l + 1);
        r++;
      }
      return max;
    }
}
