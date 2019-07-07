class Solution {
    public String minWindow(String s, String t) {
        int[] counter = new int[128];
        for (char c: t.toCharArray()) {
            counter[c] += 1;
        }

        int start = 0;
        int end = 0;
        int count = t.length();
        String result = "";
        int min = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (counter[c] > 0) count--;
            // Important - letters not in T will be negative value
            counter[c]--;

            while (count == 0) {
                if (end - start < min) {
                    min = end - start;
                    result = s.substring(start, end + 1);
                }

                // Important - letters not in T will not be position, at most 0
                counter[s.charAt(start)]++;
                if (counter[s.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
