class Solution {
    // https://stackoverflow.com/questions/13032116/trie-complexity-and-searching
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0 || dict == null || dict.size() == 0) return sentence;

        TrieNode root = buildTrie(dict);
        StringBuilder sb = new StringBuilder();
        String[] data = sentence.split(" ");
        for (String word : data) {
            String replacedString = findInTree(root, word);
            if (replacedString == null) {
                sb.append(word + " ");
            } else {
                sb.append(replacedString + " ");
            }
        }
        return sb.toString().trim();
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode('#');
        TrieNode parent = null;
        TrieNode node = null;
        for (String word : dict) {
            parent = root;
            for (int index = 0; index < word.length(); index++) {
                char c = word.charAt(index);
                if (parent.letters[c - 'a'] == null) {
                    node = new TrieNode(c);
                    parent.letters[c - 'a'] = node;
                } else {
                    node = parent.letters[c - 'a'];
                }
                parent = node;
            }
            parent.isWord = true;
        }
        return root;
    }

    private String findInTree(TrieNode root, String word) {
        int index = 0;
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        while (index < word.length()) {
            int wordIndex = word.charAt(index) - 'a';
            if (node.letters[wordIndex] == null) return null;
            if (node.letters[wordIndex] != null) {
                node = node.letters[wordIndex];
                sb.append(node.letter);
                if (node.isWord) return sb.toString();
            }
            index++;
        }
        return sb.toString();
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] letters;
        char letter;

        public TrieNode(char letter) {
            this.letter = letter;
            this.letters = new TrieNode[26];
        }
    }
}
