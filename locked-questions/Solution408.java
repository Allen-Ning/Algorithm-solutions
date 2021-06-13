class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < abbr.length() && j < word.length()) {
            char c = abbr.charAt(i);
            if (c == word.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (c >= 'a' && c <= 'z') return false;
            if (c == '0') return false;

            int num = 0;
            while (i < abbr.length()) {
                c = abbr.charAt(i); 
                if (c < '0' || c > '9') break;

                num = num * 10 + c - '0';
                i++;
            }
            j += num;
        }

        if (i != abbr.length() || j != word.length()) return false;
        return true;
    }
}