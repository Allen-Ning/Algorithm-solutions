class Trie {

    Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        Node node = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            Node child = node.children[index];

            if (child == null) {
                child = new Node(c);
                node.children[index] = child;
            }
            node = child;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node child = node.children[index];

            if (child == null) return false;
            node = child;
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            Node child = node.children[index];

            if (child == null) return false;
            node = child;
        }
        return true;
    }

    class Node {
        char c;
        Node[] children;
        boolean isWord;

        public Node(char c) {
            this.c = c;
            children = new Node[26];
            this.isWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */