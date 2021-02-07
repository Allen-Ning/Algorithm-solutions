class Solution {
    public int[] decode(int[] encoded) {
         // trick -> show the logic by example below
        // perms = [2,4,1,5,3]
        // encoded = [6,5,4,6]
        //              0         1         2       3
        // encoded = [a0 ^ a1, a1 ^ a2, a2 ^ a3, a3 ^ a4]

        //       encoded[1] ^ encoded[3]
        // value1 = a1 ^ a2 ^ a3 ^ a4
        // value2 = a0 ^ a1 ^ a2 ^ a3 ^ a4 = 1 ^ 2 ^ 3 ^ 4 ^ 5 based on the condition (There is an integer array perm that is a permutation of the first n positive integers, where n is always odd)
        
        // value1 ^ value2 = a1 ^ a2 ^ a3 ^ a4 ^ a0 ^ a1 ^ a2 ^ a3 ^ a4
        // cos 1. a1 ^ a2 = a2 ^ a1,
        //     2. a ^ a = 0

        // value1 ^ value2 = 0 ^ a0
        // the first value will a0 = value1 ^ value2 ^ 0 in perms

        // based on the first value, we can then get the second value
        // first ^ second = encoded_first => second = encoded_first ^ first
        //                                => first = encoded_first ^ second
        //                                => encoded_first = first ^ second
        int result = 1;
        int n = encoded.length + 1;
        for (int i = 2; i <= n; i++) result ^= i;

        for (int i = 1; i < encoded.length; i += 2) result ^= encoded[i];
        int first = result ^ 0;

        int[] results = new int[encoded.length + 1];
        results[0] = first;
        int prev = first;
        for (int i = 1; i < results.length; i++) {
            int current = prev ^ encoded[i - 1];
            results[i] = current;
            prev = current;
        }
        return results;    
    }
}
