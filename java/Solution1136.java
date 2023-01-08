class Solution {
    // trick -> tag: topological sort
    //          inDegress array + hashMap + bfs
    public int minimumSemesters(int n, int[][] relations) {    
        // indegree
        int[] inDegrees = new int[n + 1];
        HashMap<Integer, Set<Integer>> map = new HashMap();

        // bfs
        for (int[] relation : relations) {
            int from = relation[0];
            int to = relation[1];
            inDegrees[to] += 1;
            Set<Integer> set = map.getOrDefault(from, new HashSet());
            set.add(to);
            map.put(from, set);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] > 0) continue;
            queue.offer(i);
        }

        int count = 0;
        int result = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int fromCourse = queue.poll();
                count++;
                Set<Integer> toCourses = map.get(fromCourse);
                if (toCourses == null) continue;

                for (Integer toCourse : toCourses) {
                    inDegrees[toCourse] -= 1;
                    if (inDegrees[toCourse] == 0) queue.offer(toCourse);
                }
            }
            result++;
        }
        return count == n ? result : -1;
    }
}