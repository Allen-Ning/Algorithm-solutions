class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet();
        String[] map = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) sb.append(map[word.charAt(i) - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}