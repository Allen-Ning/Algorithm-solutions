class Node {
    char value;
    boolean isWord = false;
    Node[] children = new Node[26];

    public Node(char value) {
        this.value = value;
    }
}

class WordDictionary {

    Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('@');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                Node child = new Node(c);
                node.children[index] = child;
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Node node = helper(word, root, 0);
        if (node == null) return false;
        return node.isWord;
    }

    private Node helper(String word, Node node, int start) {
        if (start >= word.length()) {
            return node;
        }

        char c = word.charAt(start);
        Node returnNode = null;
        if (c != '.') {
            int index = c - 'a';
            if (node.children[index] == null) return null;
            returnNode = helper(word, node.children[index], start + 1);
        } else {
            for (Node child : node.children) {
                if (child == null) continue;
                returnNode = helper(word, child, start + 1);
                if (returnNode != null && returnNode.isWord) break;
            }
        }
        return returnNode;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
