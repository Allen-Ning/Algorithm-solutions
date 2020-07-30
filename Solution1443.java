class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = buildMap(edges);
        boolean[] isVisited = new boolean[n];
        int result = helper(map, hasApple, isVisited, 0);
        return result;
    }

    private Map<Integer, List<Integer>> buildMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge : edges) {
            int node = edge[0];
            int child = edge[1];
            List<Integer> list = map.getOrDefault(node, new ArrayList());
            list.add(child);
            map.put(node, list);
            map.put(node, list);

            list = map.getOrDefault(child, new ArrayList());
            list.add(node);
            map.put(child, list);
            map.put(child, list);
        }
        return map;
    }

    private int helper(Map<Integer, List<Integer>> map, List<Boolean> hasApple, boolean[] isVisited, int node) {
        if (isVisited[node]) return 0;

        int result = 0;
        isVisited[node] = true;
        for (int child : map.get(node)) result += helper(map, hasApple, isVisited, child);

        // trick -> node != 0 means node is not root
        if (result > 0 && node != 0) result += 2;
        if (result == 0 && hasApple.get(node)) result += 2;
        return result;
    }
}
