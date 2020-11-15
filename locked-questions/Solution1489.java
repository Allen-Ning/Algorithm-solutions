class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> results = new ArrayList();
        if (n == 0 || edges.length == 0) return results;

        HashMap<int[], Integer> map = new HashMap();
        for (int i = 0; i < edges.length; i++) map.put(edges[i], i);

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        MST mst = new MST(n, edges, null, null);

        List<Integer> critical = new ArrayList();
        List<Integer> pCritical = new ArrayList();
        results.add(critical);
        results.add(pCritical);

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            MST mstWithEdge = new MST(n, edges, edge, null);
            if (mstWithEdge.value > mst.value) continue;
            MST mstWithoutEdge = new MST(n, edges, null, edge);

            // trick -> possible critical
            if (mstWithoutEdge.value > mst.value) {
                critical.add(map.get(edge));
            } else if (mstWithoutEdge.value == mst.value) {
                pCritical.add(map.get(edge));
            }
        }
        return results;
    }

    class MST {
        private int value;
        private int[] parents;
        private int[] rank;

        public MST(int n, int[][] edges, int[] includedEdge, int[] excludedEdge) {
            this.parents = new int[n];
            // trick -> union find by rank init
            this.rank = new int[n];
            for (int i = 0; i < parents.length; i++) parents[i] = i;
            this.value = this.value(n, edges, includedEdge, excludedEdge);
        }

        private int find(int node) {
            if (node == parents[node]) return node;
            parents[node] = find(parents[node]);
            return parents[node];
        }

        private void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            // trick -> union find by rank
            if (rank[parent1] > rank[parent2]) {
                parents[parent2] = parent1;
            } else if (rank[parent1] < rank[parent2]) {
                parents[parent1] = parent2;
            } else if (rank[parent1] == rank[parent2]) {
                parents[parent2] = parent1;
                parent1++;
            }
        }

        private int value(int n, int[][] edges, int[] includedEdge, int[] excludedEdge) {
            int[] firstEdge = null;
            if (includedEdge != null) firstEdge = includedEdge;

            int count = 0;
            int result = 0;
            if (firstEdge != null) {
                union(firstEdge[0], firstEdge[1]);
                result += firstEdge[2];
                count++;
            }

            for (int[] edge : edges) {
                if (isSameEdge(edge, excludedEdge)) continue;
                int parent1 = find(edge[0]);
                int parent2 = find(edge[1]);
                if (parent1 == parent2) continue;

                union(parent1, parent2);
                result += edge[2];
                count++;
            }
            // trick -> count != n - 1 means not all nodes are included in MST
            return count == (n - 1) ? result : Integer.MAX_VALUE;
        }

        private boolean isSameEdge(int[] e1, int[] e2) {
            if (e1 == null && e2 == null) return true;
            if (e1 == null || e2 == null) return false;

            return e1[0] == e2[0] && e1[1] == e2[1];
        }

        private int value() {
            return this.value;
        }
    }
}