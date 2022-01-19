class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        int[] check = new int[256];
        int counter = 0;
        int start = 0;
        // trick -> classic sliding windown question:
        //          1. move the end pointer as much as the sliding window can until it's more than k
        //          2. move the start pointer to meet the requirement -sliding window at most k
        //          3. record the best lenght between start pointer (included) and end pointer (included)
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (check[c]++ == 0) counter++;
            while (counter > k) {
                char n = s.charAt(start);
                if (--check[n] == 0) counter--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}