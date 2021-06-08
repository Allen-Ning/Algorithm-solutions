class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] results = new int[encoded.length + 1];
        results[0] = first;
        // trick -> if c = a ^ b,
        //          use XOR operations to get below
        //
        //          b = c ^ a
        //          b = a ^ c
        //          a = c ^ b
        //          a = b ^ c
        int prev = first;
        for (int i = 1; i < results.length; i++) {
            int current = prev ^ encoded[i - 1];
            results[i] = current;
            prev = current;
        }
        return results;
    }
}
