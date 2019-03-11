class Solution {
    public int mySqrt(int x) {
    long low = 0;
    long high = x + 1;
    while(low < high) {
      long mid = low + (high - low) / 2;
      if  (mid * mid > x) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return (int)low - 1;
  }
}
