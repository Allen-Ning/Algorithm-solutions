class Solution {
    public boolean isSubsequence(String s, String t) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < s.length() && index2 < t.length()) {
            char c1 = s.charAt(index1);
            char c2 = t.charAt(index2);

            if (c1 == c2) {
                index1++;
                index2++;
                continue;
            }
            index2++;
        }

        return index1 >= s.length();
    }
}