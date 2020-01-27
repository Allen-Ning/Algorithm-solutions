class Solution {
  // more than one A
  // more than  two continous L
  // The result need to be returned after mod 10⁹ + 7.

  public int checkRecord(int n) {
    // L P A
    // 1 A or 0 A
    // end 0L, 1L, 2L
    long[] dp0 = new long[n + 1];
    long[] dp1 = new long[n + 1];
    long[] dp2 = new long[n + 1];
    long[] dp3 = new long[n + 1];
    long[] dp4 = new long[n + 1];
    long[] dp5 = new long[n + 1];

    dp0[0] = 1;
    dp1[0] = 0;
    dp2[0] = 0;
    dp3[0] = 0;
    dp4[0] = 0;
    dp5[0] = 0;

    // Since the result is generated by adding a lot of middle results together,
    // in order to make sure that every middle result and the final result won't exceed INT_MAX,
    // we need to do mod for every middle result, and for every 2-middle-result-addition.
    long m = (long) Math.pow(10, 9) + 7;
    for (int i = 1; i <= n; i++) {
      // 0 -> A, end -> 0L
      dp0[i] = (dp0[i - 1] + dp1[i - 1] + dp2[i -1]) % m; // must end with P
      // 0 -> A, end -> 1L
      dp1[i] = dp0[i -1] % m; // L
      // 0 -> A, end -> 2L
      dp2[i] = dp1[i- 1] % m;
      // 1 -> A, end -> 0L
      dp3[i] = (dp0[i - 1] + dp1[i - 1] + dp2[i -1] + dp3[i -1] + dp4[i -1] + dp5[i -1]) % m;
      // 1 -> A, end -> 1L
      dp4[i] = dp3[i - 1] % m;
      // 1 -> A, end -> 2L
      dp5[i] = dp4[i - 1] % m;
    }
    long result = dp0[n] + dp1[n] + dp2[n] + dp3[n] + dp4[n] + dp5[n];
    return (int) (result % m);
  }
}