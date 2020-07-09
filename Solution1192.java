class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map = buildMap(connections);
        boolean[] isVisited = new boolean[n];
        int[] steps = new int[n];
        List<List<Integer>> results = new ArrayList();
        helper(map, results, isVisited, steps, -1, 0, 0);
        return results;
    }

    private Map<Integer, List<Integer>> buildMap(List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (List<Integer> connection : connections) {
            int value1 = connection.get(0);
            int value2 = connection.get(1);
            List<Integer> list = map.getOrDefault(value1, new ArrayList<Integer>());
            list.add(value2);
            map.put(value1, list);

            list = map.getOrDefault(value2, new ArrayList<Integer>());
            list.add(value1);
            map.put(value2, list);
        }
        return map;
    }

    private int helper(Map<Integer, List<Integer>> map, List<List<Integer>> results, boolean[] isVisited, int[] steps, int prev, int current, int step) {
        isVisited[current] = true;
        int returnedStep = step;
        steps[current] = step;
        for (int next : map.get(current)) {
            if (next == prev) continue;
            if (isVisited[next]) {
                returnedStep = Math.min(returnedStep, steps[next]);
                continue;
            }

            int nextStep = helper(map, results, isVisited, steps, current, next, step + 1);
            if (nextStep > step) {
                List<Integer> result = new ArrayList();
                result.add(current);
                result.add(next);
                results.add(result);
            }
            returnedStep = Math.min(returnedStep, nextStep);
        }
        return returnedStep;
    }
}
