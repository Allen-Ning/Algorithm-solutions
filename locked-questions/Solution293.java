class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> results = new ArrayList();
        char[] letters = currentState.toCharArray();
        for (int i = 0; i < letters.length - 1; i++) {
            char first = letters[i];
            char second = letters[i + 1];

            if (first != '+' || second != '+') continue;

            letters[i] = '-';
            letters[i + 1] = '-';
            results.add(new String(letters));
            letters[i] = '+';
            letters[i + 1] = '+';
        }
        return results;
    }
}