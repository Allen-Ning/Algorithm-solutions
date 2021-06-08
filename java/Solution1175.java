class Solution {
    public int numPrimeArrangements(int n) {
        int primeCounter = count(n);
        int nonPrimeCounter = n - primeCounter;
        long mod = (long) Math.pow(10, 9) + 7;
        long result = 1;
        for (int i = primeCounter; i >= 1; i--) result = result * i % mod;
        for (int i = nonPrimeCounter; i >= 1; i--) result = result * i % mod;
        return (int) result;
    }

    private int count(int n) {
        boolean[] primes = new boolean[n + 1];
        // trick -> arrays fill not include toIndex
        //          it will fill from index 2 to index n
        Arrays.fill(primes, 2, n + 1, true);

        // trick -> we don't need to check i > sqrt(n) cos,
        //          cos A * B = n, if A > sqrt(n),
        //          it means B < sqrt(n) which should be check already
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) continue;
            // trick -> j = i * i is a trick for optimized
            //          it will check i * i, i * i + i, i * i + 2i
            //                        i* i, i * (i + 1), i * (i + 2)
            for (int j = i * i; j <= n; j += i) primes[j] = false;
        }

        int counter = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) counter++;
        }
        return counter;
    }
}
