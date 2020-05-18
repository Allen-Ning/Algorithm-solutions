class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (int i = 0; i < chars.length(); i++) map[chars.charAt(i) - 'a'] += 1;

        int result = 0;
        for (String word : words) {
            int[] copy = Arrays.copyOf(map, map.length);
            boolean isResult = true;
            for (int i = 0; i < word.length(); i++) {
                if (copy[word.charAt(i) - 'a'] > 0) {
                    copy[word.charAt(i) - 'a'] -= 1;
                    continue;
                }
                isResult = false;
                break;
            }
            if (isResult) result += word.length();
        }
        return result;
    }
    
}
