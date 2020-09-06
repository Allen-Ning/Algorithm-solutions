public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int p = 0;
        int i = 0;
        while (i < abbr.length()) {
            char c = abbr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (p >= word.length()) return false;
                if (abbr.charAt(i) != word.charAt(p)) return false;
                p++;
                i++;
            } else {
                int num = 0;
                while (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                    // trick -> check against leading zero
                    //          "01" -> "a", expected false
                    if (num == 0) return false;

                    i++;
                    if (i >= abbr.length()) break;
                    c = abbr.charAt(i);
                }
                p += num;
            }
        }
        if (p != word.length()) return false;
        return true;
    }
}