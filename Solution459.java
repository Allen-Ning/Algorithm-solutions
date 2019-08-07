class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 1) return false;
        int size = s.length();
        // trick -> test the bigger substring cos it's quicker
        for (int i = s.length() / 2; i >= 0; i--) {
            int length = i + 1;
            
            // handle corner case to two letters'ab'
            if (size == length) continue;
            if (size % length != 0) continue;


            String first = s.substring(0, i + 1);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size / length; j++) {
                sb.append(first);
            }
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
