class Solution {
    public int preimageSizeFZF(int K) {
        long l = 0;
        // trick -> we need long type here cos k could be super large number like Interger.MAX_VALUE
        //          if so, we need a long number to get zeros of K
        long r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (countFive(mid) >= K) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (countFive(l) == K) {
            return 5;
        } else {
            return 0;
        }
    }

    // trikck -> 0 is make by 2 * 5, cos there are more 2 than 5
    //           so that 0 highly depends on the number of 5
    //           countFive is achived by / 5, / 25, / 125
    //           when / 5 -> add one 5 for numbers like 5, 10, 15, 25(+1)...125(+1)
    //           when / 25 -> add one 5 for numbers like 25(+1), 50, 125(+1)
    //           when / 125 -> add one 5 for numbers like 125(+1), 250, 375
    //           so that 25 contributes two 5
    //                   125 contributes three 5
    private long countFive(long n) {
        long result = 0;
        for (long i = 5; i <= n; i *= 5) {
            result += n / i;
        }
        return result;
    }
}
