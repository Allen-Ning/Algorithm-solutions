class Solution {
    // trick -> the question use the trick (a + b) % 60 == (a % 60 + b % 60) % 60
    //          e.g (20 + 40) % 60 == (20 % 60 + 40 % 60) % 60
    public int numPairsDivisibleBy60(int[] time) {
        int[] buckets = new int[60];
        int result = 0;
        for (int t : time) {
            int value = (t % 60);
            // trick -> the last % 60 is to avoid num like 60
            //          e.g. when t = 60
            //               value = t % 60 = 0
            //               searchedValue = (60 - 0) % 60 = 0
            int searchedValue = (60 - value) % 60;
            result += buckets[searchedValue];
            buckets[value]++;
        }
        return result;
    }
}
