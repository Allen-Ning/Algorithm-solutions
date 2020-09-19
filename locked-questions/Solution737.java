public class Solution {
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        UnionFind uf = new UnionFind();
        for (List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            if (!uf.hasKey(word1)) uf.set(word1, word1);
            if (!uf.hasKey(word2)) uf.set(word2, word2);
            uf.union(word1, word2);
        }

        if (words1.length != words2.length) return false;
        for (int i = 0; i < words1.length; i++) {
            // trick -> if two string are same -> return true
            //          if two string are not same, one has no similarities -> return false
            //          if two string are not same, both of them have similarites and their parents of similaries are not same -> return false
            if (words1[i].equals(words2[i])) continue;
            if (!uf.hasKey(words1[i]) ||
                !uf.hasKey(words2[i]) ||
                !uf.find(words1[i]).equals(uf.find(words2[i]))
            ) return false;
        }
        return true;
    }

    class UnionFind {
        Map<String, String> parents;
        Map<String, Integer> ranks;

        public UnionFind() {
            this.parents = new HashMap();
            this.ranks = new HashMap();
        }

        public void set(String word, String parent) {
            parents.put(word, parent);
        }

        public boolean hasKey(String word) {
            return parents.containsKey(word);
        }

        public String find(String word) {
            if (word.equals(parents.get(word))) return word;
            String parent = find(parents.get(word));
            parents.put(word, parent);
            return parent;
        }

        public void union(String word1, String word2) {
            String parentWord1 = find(word1);
            String parentWord2 = find(word2);
            // trick -> we need to update rank if rank ties
            if (ranks.getOrDefault(parentWord1, 0) > ranks.getOrDefault(parentWord2, 0)) {
                parents.put(parentWord2, parentWord1);
            } else if (ranks.getOrDefault(parentWord1, 0) < ranks.getOrDefault(parentWord2, 0)) {
                parents.put(parentWord1, parentWord2);
            } else {
                parents.put(parentWord2, parentWord1);
                ranks.put(parentWord1, ranks.getOrDefault(parentWord1, 0) + 1);
            }
        }
    }
}