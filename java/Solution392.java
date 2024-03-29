class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            char c1 = s.charAt(p1);
            char c2 = t.charAt(p2);

            if (c1 == c2) p1++;
            p2++;
        }
        return p1 >= s.length();
    }
}