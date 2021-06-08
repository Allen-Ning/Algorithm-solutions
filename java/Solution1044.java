class Solution {
    public String longestDupSubstring(String S) {
        char[] data = S.toCharArray();
        int l = 0;
        int h = data.length;
        int[] result = null;
        int[] temp = null;
        // trick -> use binary search to guess the best value
        while (l < h) {
            int d = l + (h - l) / 2;
            temp = search(S, data, d);
            if (temp != null) {
                l = d + 1;
                result = temp;
            } else {
                h = d;
            }
        }
        if (result == null) return "";
        return S.substring(result[0], result[1]);
    }

    private int[] search(String S, char[] data, int d) {
        // trick -> the most tricketst part fot this question is to use mod
        // trick -> this is question, mod could introduce hash collision, which can be resolved by one of them above:
        //          1. we can add one hash table with key: custom hashcode (Integer), value: selected subtrings (LinkedList<String>) as value to avoid hash collision
        //          2. we can add one more hash function to avoid hash collision, e.g. sumup all letter values (one of the naive way)
        long mod = (long) Math.pow(2, 34);
        // include d letters
        Set<Long> set = new HashSet();
        int base = 26;

        long current = 0;
        int start = 0;
        //  trick -> be careful not include end
        int end = 0;

        long map = 1;
        // trick -> we need to mod here to avoid value to big
        for (int i = 1; i < d; i++) map = map * base % mod;

        // init process
        while (end < start + d) {
            current = current * base + (data[end] - 'a');
            current %= mod;
            end++;
        }
        set.add(current);

        while (end < data.length) {
            // trick -> start will be the high bit and end will be the low bit
            //          e.g.  cbb -> 2 * 26^2 + 1 * 26^1 + 1 * 26^0
            // trick -> we also need + mod here to avoid negative value introduce by current - (data[start] - 'a') * map
            current = data[end] - 'a' + base * (current - (data[start] - 'a') * map + mod);
            current %= mod;

            start++;
            end++;
            if (set.contains(current)) return new int[]{start, end};
            set.add(current);
        }
        return null;
    }
}