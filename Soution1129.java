class Solution {
    class Node {
        int value;
        boolean isNodeFromRedEdge;

        public Node(int value, boolean isNodeFromRedEdge) {
            this.value = value;
            this.isNodeFromRedEdge = isNodeFromRedEdge;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, Set<Integer>> redMap = new HashMap();
        Map<Integer, Set<Integer>> blueMap = new HashMap();
        set(red_edges, redMap);
        set(blue_edges, blueMap);

        int[] results = new int[n];
        Arrays.fill(results, -1);
        results[0] = 0;
        boolean[][] isVisited = new boolean[n][2];

        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(0, true));
        isVisited[0][0] = true;
        queue.offer(new Node(0, false));
        isVisited[0][1] = true;

        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (results[current.value] == -1) results[current.value] = step;
                if (current.isNodeFromRedEdge) {
                    if (blueMap.get(current.value) == null) continue;
                    for (int next : blueMap.get(current.value)) {
                        if (isVisited[next][1]) continue;
                        Node nextNode = new Node(next, false);
                        queue.offer(nextNode);
                        isVisited[next][1] = true;
                    }
                } else {
                    if (redMap.get(current.value) == null) continue;
                    for (int next : redMap.get(current.value)) {
                        if (isVisited[next][0]) continue;
                        Node nextNode = new Node(next, true);
                        queue.offer(nextNode);
                        isVisited[next][0] = true;
                    }
                }
            }
            step++;
        }
        return results;
    }

    private void set(int[][] edges, Map<Integer, Set<Integer>> map) {
        for (int[] pair : edges) {
            Set<Integer> set = map.getOrDefault(pair[0], new HashSet());
            set.add(pair[1]);
            map.put(pair[0], set);
        }
    }
}