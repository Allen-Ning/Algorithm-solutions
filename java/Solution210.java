class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Set[] dependentCourses = new Set[numCourses];
        Queue<Integer> queue = new LinkedList();
        List<Integer> results = new ArrayList();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[1];
            int nextCourse = prerequisite[0];
            indegrees[nextCourse] += 1;

            Set<Integer> set = dependentCourses[course];
            if (set == null) {
                set = new HashSet();
                dependentCourses[course] = set;
            }
            set.add(nextCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] > 0) continue;

            queue.offer(i); 
        }

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer course = queue.poll();
                results.add(course);

                Set<Integer> nextCourses = dependentCourses[course];
                if (nextCourses == null) continue;

                for (Integer nextCourse : nextCourses) {
                    if (--indegrees[nextCourse] > 0) continue;

                    queue.offer(nextCourse);
                }
            }
        }

        // trick -> corner case
        // impossible to finish all courses -> return empty
        if (results.size() != numCourses) return new int[] {};

        int[] finalResults = new int[numCourses];
        for (int i = 0; i < results.size(); i++) {
            finalResults[i] = results.get(i);
        }
        return finalResults;
    }
}