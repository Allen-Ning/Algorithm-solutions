class Solution {
    // bellman-ford
    public int networkDelayTime(int[][] times, int N, int K) {
      long[] values = new long[N];

      // trick -> this is a little bit trick here fill Integer.MAX_VALUE
      Arrays.fill(values, Integer.MAX_VALUE);
      values[K - 1] = 0;

      for (int i = 1; i < N; i++) {
        for (int[] time : times) {
          int start = time[0] - 1;
          int end = time[1] - 1;
          int w = time[2];
          values[end] = (long) Math.min(values[end], (long)(values[start] + w));
        }
      }

      long max = 0;
      for (long value : values) max = Math.max(value, max);
      return max == Integer.MAX_VALUE ? -1 : (int) max;
    }
}
