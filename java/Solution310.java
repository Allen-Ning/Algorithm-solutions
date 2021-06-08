class Solution {
    // 3 -> [4]
    // 4 -> [3]
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> list = new LinkedList();
        if (n == 0) return list;

        if (edges == null || edges.length == 0) {
            for (int i = 0; i < n; i++) list.offer(i);
            return list;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        HashSet<Integer> values = null;
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            values = map.getOrDefault(node1, new HashSet());
            values.add(node2);
            map.put(node1, values);
         
            values = map.getOrDefault(node2, new HashSet());
            values.add(node1);
            map.put(node2, values);
        }

        LinkedList<Integer> queue = new LinkedList();
        addToQueue(queue, map);
        // trick -> very easy to make mistake for implemntation here
        List<Integer> result = queue;
        while (queue.size() > 0) {
            result = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                // trick -> this is for getting results
                result.add(node);
                HashSet<Integer> set = map.get(node);
                Integer nextNode = null;
                if (set.size() > 0) {
                    nextNode = set.iterator().next();
                    set.remove(nextNode);
                }
                
                if (nextNode != null) {
                    set = map.get(nextNode);
                    if (set.size() > 0) set.remove(node);
                }
                
                if (nextNode != null && map.get(nextNode).size() == 1) {
                    queue.add(nextNode);
                }
            }
        }
        return result;
    }

    private void addToQueue(LinkedList<Integer> queue, HashMap<Integer, HashSet<Integer>> map) {
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) queue.add(entry.getKey());
        }
    }
}
