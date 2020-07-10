class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] map = buildMap(n, connections);
        boolean[] isVisited = new boolean[n];
        int[] steps = new int[n];
        List<List<Integer>> results = new ArrayList();
        helper(map, results, isVisited, steps, -1, 0, 0);
        return results;
    }

    private List<Integer>[] buildMap(int n, List<List<Integer>> connections) {
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<Integer>();

        for (List<Integer> connection : connections) {
            int value1 = connection.get(0);
            int value2 = connection.get(1);
            map[value1].add(value2);
            map[value2].add(value1);
        }
        return map;
    }

    private int helper(List<Integer>[] map, List<List<Integer>> results, boolean[] isVisited, int[] steps, int prev, int current, int step) {
        isVisited[current] = true;
        int returnedStep = step;
        steps[current] = step;
        for (int next : map[current]) {
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
