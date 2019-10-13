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
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (queue.size() > 0) {
            int preCourse = queue.poll();
            results[counter] = preCourse;
            counter++;

            if (!map.containsKey(preCourse)) continue;
            List<Integer> courses = map.get(preCourse);
            for (int course : courses) {
                indegrees[course] -= 1;
                if (indegrees[course] == 0) {
                    queue.add(course);
                }
            }
        }
        return counter == numCourses ?  results : new int[0];
    }
}
