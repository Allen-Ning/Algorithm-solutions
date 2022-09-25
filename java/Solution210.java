class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // trick -> corner case1
        // numCourses is zero -> return empty
        if (numCourses == 0) return new int[0];

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

        List<Integer> results = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        boolean[] isVisited = new boolean[numCourses];

        // trick -> add all course whose indegree is zero
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] != 0) continue;
            queue.offer(i);
        }

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // trick -> syntax
                Integer course = queue.poll();
                results.add(course);
                isVisited[course] = true;
                List<Integer> nextCourses = courses.get(course);

                if (nextCourses == null) continue;
                for (int nextCourse : nextCourses) {
                    if (isVisited[nextCourse]) continue;
                    indegrees[nextCourse]--;

                    if (indegrees[nextCourse] == 0) queue.offer(nextCourse);
                }
            }
        }

        // trick -> corner case2
        // impossible to finish all courses -> return empty
        if (results.size() < numCourses) return new int[0];
        int[] finalResults = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            finalResults[i] = results.get(i);
        }
        return finalResults;
    }
}
