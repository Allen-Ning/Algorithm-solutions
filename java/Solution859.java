class Solution {
    public boolean buddyStrings(String s, String goal) {
        int diff = 0;
        boolean isRepeated = false;
        char[] letters = new char[32];
        StringBuilder sb = new StringBuilder();

        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != goal.charAt(i)) {
                sb.append(c);
                sb.append(goal.charAt(i));
                diff++;
                if (diff >= 3) return false;
            }

            letters[c - 'a'] += 1;
            if (letters[c - 'a'] > 1) isRepeated = true;
        }

        if (diff == 2 && isPalindrome(sb.toString())) return true;
        if (diff == 0 && isRepeated) return true;

        return false;
    }

    private boolean isPalindrome(String str) {
        return str.charAt(0) == str.charAt(3) && str.charAt(1) == str.charAt(2);
    }
}