class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> results = new ArrayList();
        String check = transform(pattern);
        for (String word : words) {
            if (transform(word).equals(check)) results.add(word);
        }
        return results;
    }

    // trick -> abb: 122
    //          mee: 122
    //          abc: 123
    private String transform(String word) {
        Map<Character, Character> map = new HashMap();
        char basedLabel = '1';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = map.getOrDefault(word.charAt(i), basedLabel++);
            map.put(word.charAt(i), c);
            sb.append(c);
        }
        return sb.toString();
    }
}
