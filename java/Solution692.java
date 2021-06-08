class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> finalResults = new ArrayList();
        if (words == null || words.length == 0 || k == 0) return finalResults;

        HashMap<String, Integer> map = new HashMap();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<Word> queue = new PriorityQueue<Word>((a, b) -> check(a, b));
        for (Map.Entry<String, Integer> each : map.entrySet()) {
            String word = each.getKey();
            int freqency = each.getValue();

            queue.offer(new Word(word, freqency));
            if (queue.size() > k) queue.poll();
        }

        List<Word> results = new ArrayList();
        while (!queue.isEmpty())  results.add(queue.poll());

        for (int i = results.size() - 1; i >= 0; i--) {
            finalResults.add(results.get(i).word);
        }
        return finalResults;
    }

    // trick -> after sorting, lower frequence with higher alphabetical show in top of heap
    public int check(Word a, Word b) {
        return a.freq == b.freq ? -a.word.compareTo(b.word) : (a.freq - b.freq);
    }
}

class Word {
    String word;
    int freq;

    public Word(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

}
