class Solution {
    public int countPrimeSetBits(int L, int R) {
        // trick -> the max number of prime we need to check is 19 
        //          due to the max 10^6 only have 20 bits
        // 10^6 -> 11110100001001000000 (20 bits to binary)
        Set<Integer> primes = new HashSet(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int result = 0;
        for (int i = L; i <= R; i++) {
            int counter = 0;
            int value = i;
            while (value > 0) {
                if ((value & 1) == 1) counter++;
                value >>= 1;
            }
            if (primes.contains(counter)) result++;
        }
        return result;
    }
}
