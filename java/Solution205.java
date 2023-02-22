class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] letters = new int[128];
        int[] letters2 = new int[128];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            int index1 = (int) s.charAt(i);
            int index2 = (int) t.charAt(i);

            // check
            if (letters[index1] != letters2[index2]) return false;
            letters[index1] = i + 1;
            letters2[index2] = i + 1;
        }
        return true;
    }
}