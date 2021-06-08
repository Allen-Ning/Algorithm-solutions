class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null && s2 == null) return true;

        int total = 0;
        char[] result = new char[4];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) continue;

            total++;
            if (total == 1) {
                result[0] = c1;
                result[1] = c2;
            } else if (total == 2) {
                result[2] = c1;
                result[3] = c2;
                if (result[0] != result[3] || result[1] != result[2]) return false;
            } else {
                return false;
            }
        }

        if (total == 0 || total == 2) return true;
        return false;
    }
}