class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] results = new int[n];
    int[] indexes = new int[primes.length];

    results[0] = 1;
    int i = 1;
    while(i <  n) {
      int minAddedNumber = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int j = 0; j < primes.length; j++) {
        results[i] = Math.min(minAddedNumber, primes[j] * results[indexes[j]]);
      }
      
      // there might be multiple numbers matching the criteria and exactly same value of numbers
      // n = 12, primes = [2,7,13,19]
      // [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
      // could be 2 * 7 (indexes[3]) = 14
      // could be 7 * 2 (indexes[1]) = 14
      for (int j = 0; j < primes.length; j++) {
        if (results[i] == primes[j] * results[indexes[j]]) {
          indexes[j]++;
        }
      }
      i++;
    }
    return results[n -1];
  }
}
