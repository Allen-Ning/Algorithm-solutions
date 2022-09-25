class Solution {
    // trick -> topologic sort = indegree + bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // preprocesing
        HashMap<Integer, List<Integer>> courses = new HashMap();
        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[1];
            int second = prerequisite[0];
            indegrees[second]++;

            List<Integer> nextCourses = courses.getOrDefault(first, new ArrayList());
            nextCourses.add(second);
            courses.put(first, nextCourses);
        }

        Queue<Integer> queue = new LinkedList();
        int counter = 0;
        boolean[] isVisited = new boolean[numCourses];
        int firstCourse = -1;
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] != 0) continue;
            queue.offer(i);
        }

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // trick -> syntax
                Integer course = queue.poll();
                isVisited[course] = true;
                counter++;
                List<Integer> nextCourses = courses.get(course);

                if (nextCourses == null) continue;
                for (int nextCourse : nextCourses) {
                    if (isVisited[nextCourse]) continue;
                    indegrees[nextCourse]--;

                    if (indegrees[nextCourse] == 0) queue.offer(nextCourse);
                }
            }
        }
        return numCourses == counter;
    }
}