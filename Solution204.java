class Solution {
    // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) continue;
            counter++;
            for (int j = 2; j * i < n; j++) notPrime[i * j] = true;
        }
        return counter;
    }
}
