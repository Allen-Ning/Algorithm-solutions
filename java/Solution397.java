class Solution {
    public int integerReplacement(int n) {
        int result = 0;
        long num = (long) n;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            // trick -> when choosing betwen n + 1 or n - 1
            //          there is greedy way to choose less 1s in n + 1 or n - 1
            //          which means we keep as much as even as possissble
            //          e.g 1000 -> 100 (divided by 2) -> 10 (divided by 2) -> 1 (divided by 2)
            //          e.g 1001 -> 1000 (n - 1) -> same as above
            //
            //          when n is even, there is possible two xxx11 or xxx01
            //          as for xxx01 by -1, we will remove 1 and get xxx00 (removed one 1)
            //
            //          as for xxx11 by + 1, we will get xxx100 when xxx11 is actually xxxx011 (remved one 1),
            //                               we will get xx1000 wehn xxx11 is actually xxx0111 (removed two 1s)
            //          so at least we can promise removing one 1 which is no worse than by -1 (xxx011 -> xxx010 removed one 1)
            //          By 3 is a special, which we need to remove 1. such as 3 -> 2 -> 1 rahter than 3 -> 4 -> 2 -> 1
            } else {
                // trick -> e.g 3 -> 11 (binary
                if (num == 3 || ((num & 3) == 1)) {
                    num -= 1;
                } else {
                    num += 1;
                }
            }
            result++;
        }
        return result;
    }

    public int integerReplacement2(int n) {
        Map<Long, Integer> map = new HashMap();
        return helper(map, (long) n);
    }

    private int helper(Map<Long, Integer> map, long n) {
        if (map.containsKey(n)) return map.get(n);
        // trick -> be careful return 0 rather than 1
        //          e.g 8 -> 4 -> 2 -> 1 will output 3 rather than 4
        if (n == 1) return 0;

        int result = 0;
        if (n % 2 == 0) {
            result = helper(map, n / 2) + 1;
        } else {
            result = Math.min(helper(map, n - 1), helper(map, n + 1)) + 1;
        }
        map.put(n, result);
        return result;
    }
}