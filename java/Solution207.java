class Solution {
    //  trick -> topologic sort = map + indegree + bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // trick -> counter is enough to check if we can finish all courses
        //          no need an extra hash set to check if we have visited this course
        int counter = 0;
        int[] indegrees = new int[numCourses];
        Set[] map = new HashSet[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            indegrees[course] += 1;
            Set<Integer> set = map[preCourse];
            if (set == null) {
                set = new HashSet();
                map[preCourse] = set;
            }
            set.add(course);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            int indegree = indegrees[i];
            if (indegree > 0) continue;

            queue.offer(i);
            counter++;
        }

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer course = queue.poll();
                Set<Integer> nextCourses = map[course];
                if (nextCourses == null) continue;

                for (Integer nextCourse : nextCourses) {
                    if (--indegrees[nextCourse] > 0) continue;

                    queue.offer(nextCourse);
                    counter++;
                }
            }
        }
        return numCourses == counter;
    }
}