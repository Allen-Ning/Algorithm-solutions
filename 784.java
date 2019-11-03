class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> results = new ArrayList<String>(); 
        helper(S, 0, "", results);
        return results;
    }

    private void helper(String s, int i, String str, List<String> list) {
        if (i >= s.length()) {
            list.add(str);
            return;
        }

        char c = s.charAt(i);
        char addedChar = 'a';
        if (c <= 'z' && c >= 'a') {
            addedChar = (char) ('A' + (c - 'a'));
            helper(s, i + 1, str + addedChar, list);
        } else if (c <= 'Z' && c >= 'A') {
            addedChar = (char) ('a' + (c - 'A'));
            helper(s, i + 1, str + addedChar, list);
        }
        helper(s, i+1, str + c, list);
    }
}
