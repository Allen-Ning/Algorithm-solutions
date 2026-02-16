class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        /**
         * Trick -> the PriorityQueue comparator defines what come out of the heap
         * first,
         *
         * Since we are keeping a min-heap of size k:
         * - Lower frequency should come first (easier to remove).
         * - If frequencies tie, lexicographically larger word should come first
         * (because lexicographically smaller word has higher priority in result).
         */
        Queue<Item> minHeap = new PriorityQueue<Item>(
                (i1, i2) -> i1.freq - i2.freq == 0 ? -1 * i1.word.compareTo(i2.word) : i1.freq - i2.freq);

        // trick -> forget the syntax map.keySet()n to get all keys
        for (String word : map.keySet()) {
            minHeap.offer(new Item(word, map.get(word)));

            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<String> results = new LinkedList();
        while (minHeap.size() > 0) {
            results.addFirst(minHeap.poll().word);
        }
        return results;
    }

    class Item {
        String word;
        int freq;

        public Item(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
