class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(map, words[i], words[i + 1])) return false;
        }
        return true;
    }

    private boolean compare(HashMap<Character, Integer> map, String word1, String word2) {
        int shortLength = Math.min(word1.length(), word2.length());
        for (int i = 0; i < shortLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (map.get(c1) < map.get(c2)) {
                return true;
            } else if (map.get(c1) > map.get(c2)) {
                return false;
            }
        }
        return word1.length() > word2.length() ? false : true;

    }
}
