class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (int i = 0; i < pairs.size(); i++) uf.union(pairs.get(i).get(0), pairs.get(i).get(1));

        Map<Integer, PriorityQueue<Character>> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            int parent = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault(parent, new PriorityQueue<Character>());
            pq.add(s.charAt(i));
            map.put(parent, pq);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int parent = uf.find(i);
            char c = map.get(parent).poll();
            sb.append(c);
        }
        return sb.toString();
    }

    class UnionFind {
        int[] parents;
        int[] ranks;

        public UnionFind(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;
            ranks = new int[n];
        }

        public int find(int x) {
            if (parents[x] == x) return x;
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            // parents
            int p1 = find(x);
            int p2 = find(y);
            if (ranks[p1] < ranks[p2]) {
                parents[p1] = p2;
            } else if (ranks[p1] > ranks[p2]) {
                parents[p2] = p1;
            } else {
                parents[p2] = p1;
                ranks[p1]++;
            }
        }
    }
}
