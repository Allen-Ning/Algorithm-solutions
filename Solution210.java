class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            int[] results = new int[numCourses];
            for (int i = 0; i < numCourses; i++) results[i] = i;
            return results;
        }

        int[] indegrees = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap();

        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]] += 1;
            List<Integer> list = null;
            if (map.containsKey(prerequisite[1])) {
                list = map.get(prerequisite[1]);
            } else {
                list = new ArrayList();
            }
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        int[] results = new int[numCourses];
        int counter = 0;
        int index = findZeroIndegree(indegrees, visited);
        while (index != -1) {
            results[counter] = index;
            visited[index] = true;
            List<Integer> list = map.get(index);
            if (list != null && list.size() > 0) {
                for (int num : list) indegrees[num] -= 1;
            }
            
            index = findZeroIndegree(indegrees, visited);
            counter++;
        }
        
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] > 0) return new int[0];
        }
        return results;
    }

    private int findZeroIndegree(int[] indegrees, boolean[] visited) {
        int i = 0;
        for (i = 0; i < indegrees.length; i++) {
            if (!visited[i] && indegrees[i] == 0 ) return i;
        }
        return -1;
    }
}
