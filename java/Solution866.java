class Solution {
    public int primePalindrome(int N) {
        // trick -> handle special case
        if (N >= 8 && N <= 11) return 11;

        int length = String.valueOf(N).length();
        int start = (int) Math.pow(10, length / 2);

        // trick -> get all available palindrone and then check prime
        for (int i = start; i < 20_000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            // trick -> when num like 123321 -> pattern like abccba (which should be ignored) cos it will always be dividable by 11
            // trick -> when num like 12321 -> pattern like abcba (which could be potential result)
            int checkNum = Integer.valueOf(sb.toString() + sb.reverse().toString().substring(1));
            if (checkNum >= N && isPrime(checkNum)) return checkNum;
        }
        return -1;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
