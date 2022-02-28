class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] results = new int[k];

        // user_id, miniutes
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] log : logs) {
            int id = log[0];
            int minute = log[1];
            Set<Integer> set = map.get(id);
            if (set == null) set = new HashSet();
            set.add(minute);
            map.put(id, set);
        }

        for (int key : map.keySet()) {
            Set<Integer> set = map.get(key);
            results[set.size() - 1] += 1;
        }

        return results;
    }
}