class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        // trick - corner case when the size of str and patter not matching
        if (words.length != pattern.length()) return false;

        HashMap<String, Character> map = new HashMap();
        HashMap<Character, String> map2 = new HashMap();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);

            if (map.containsKey(word)) {
                if (map.get(word) != c) return false;
            } else {
                map.put(word, c);
            }

            if (map2.containsKey(c)) {
                if (!map2.get(c).equals(word)) return false;
            } else {
                map2.put(c, word);
            }
        }
        return true;
    }
}
