class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] indegrees = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] prerequisite : prerequisites) {
            int preCourse = prerequisite[0];
            int course = prerequisite[1];
            indegrees[course]++;
            Set<Integer> set = map.getOrDefault(preCourse, new HashSet<Integer>());
            set.add(course);
            map.put(preCourse, set);
        }

        HashMap<Integer, Set<Integer>> allPrecoursesByCourse = new HashMap();
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < indegrees.length; i++) if (indegrees[i] == 0) queue.offer(i);
        while (queue.size() > 0) {
            int preCourse = queue.poll();
            Set<Integer> allPreCourses = allPrecoursesByCourse.getOrDefault(preCourse, new HashSet<Integer>());
            if (!map.containsKey(preCourse)) continue;

            // trick -> map.get(preCourse) might return null if map doesn't have preCourse as a key, which migh cause null pointer error when using for (int course : map.get(preCourse))
            for (int course : map.get(preCourse)) {
                Set<Integer> set = allPrecoursesByCourse.getOrDefault(course, new HashSet<Integer>());
                set.add(preCourse);
                set.addAll(allPreCourses);
                allPrecoursesByCourse.put(course, set);
                indegrees[course]--;
                if (indegrees[course] == 0) queue.offer(course);
            }
        }

        List<Boolean> results = new ArrayList();
        for (int[] query : queries) {
            boolean result = allPrecoursesByCourse.containsKey(query[1]) && allPrecoursesByCourse.get(query[1]).contains(query[0]);
            results.add(result);
        }
        return results;
    }
}
