class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) return 0;
        if (S == T) return 0;

        // trick -> this is maping to each stop to all related stopes
        //          to do this will avoid 3 nested loop in order to get each stop and related stops mapping
        Map<Integer, HashSet<Integer>> map = new HashMap();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0;  j < routes[i].length; j++) {
                HashSet<Integer> set = map.getOrDefault(routes[i][j], new HashSet<Integer>());
                set.add(i);
                map.put(routes[i][j], set);
            }
        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(S);

        HashSet<Integer> set = new HashSet();
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int routeIndex : map.get(current)) {
                    // trick -> check routeIndx rather than check each stop
                    //          this will make the code much quicker
                    if (set.contains(routeIndex)) continue;
                    set.add(routeIndex);
                    for (int stop : routes[routeIndex]) {
                        if (stop == T) return step + 1;
                        queue.offer(stop);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
