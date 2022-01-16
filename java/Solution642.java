class AutocompleteSystem {
    Trie root;
    Trie current;
    String inputs;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new Trie('/', "root");
        this.current = root;

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            Trie current = root;
            for (int j = 0; j < sentence.length(); j++) {
                char c = sentence.charAt(j);
                int index = c - 'a';
                if (c == ' ') index = 26;

                if (current.letters[index] == null) current.letters[index] = new Trie(c, sentence);
                current = current.letters[index];
                current.addToRecords(sentence, times[i]);
            }
        }
        this.inputs = "";
        this.current = root;
    }

    public List<String> input(char c) {
        List<String> results = new ArrayList();
        if (c == '#') {
            Trie current = root;
            String sentence = this.inputs;
            for (int i = 0; i < inputs.length(); i++) {
                char letter = inputs.charAt(i);
                int index = letter - 'a';
                if (letter == ' ') index = 26;

                if (current.letters[index] == null) current.letters[index] = new Trie(letter, sentence);
                current = current.letters[index];
                current.addToRecords(sentence, 1);
            }
            this.current = root;
            this.inputs = "";
            return results;
        } else {
            this.inputs += c;
            int index = c - 'a';
            if (c == ' ') index = 26;
            if (current == null) return results;
            Trie trie = current.letters[index];
            int counter = 0;

            List<Node> temp = new ArrayList();
            while (trie != null && trie.maxHeap.size() > 0 && counter < 3) {
                Node node = trie.maxHeap.poll();
                temp.add(node);

                results.add(node.sentence);
                counter++;
            }

            for (Node node : temp) trie.maxHeap.offer(node);

            this.current = trie;
            return results;
        }
    }

    class Trie {
        Trie[] letters;
        char letter;
        PriorityQueue<Node> maxHeap;
        HashMap<String, Node> map;

        public Trie(char c, String sentence) {
            this.letters = new Trie[27];
            this.letter = c;
            this.maxHeap = new PriorityQueue<>((a, b) -> (a.frequence - b.frequence == 0 ? a.sentence.compareTo(b.sentence) : b.frequence - a.frequence));
            this.map = new HashMap();
        }

        public void addToRecords(String sentence, int frequence) {
            Node node;
            if (this.map.containsKey(sentence)) {
                node = this.map.get(sentence);
                node.frequence += frequence;
                maxHeap.remove(node);
                maxHeap.add(node);
            } else {
                node = new Node(sentence);
                node.frequence += frequence;
                this.maxHeap.add(node);
                this.map.put(sentence, node);
            }
        }
    }

    class Node {
        String sentence;
        int frequence;

        public Node(String sentence) {
            this.sentence = sentence;
            this.frequence = 0;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */