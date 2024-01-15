class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int result = 0;
        int[] letters = new int[256];
        Arrays.fill(letters, -1);

        for (int j = 0; j < s.length(); j++) {
            int c = s.charAt(j);
            int prevIndex = letters[(int) c];

            if (i <= prevIndex) i = prevIndex + 1;
            result = Math.max(result, j - i + 1);
            letters[(int) c] = j;
        }
        return result;
    }
}