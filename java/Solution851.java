class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] pair : richer) {
            int rich = pair[0];
            int poor = pair[1];
            Set<Integer> set = map.getOrDefault(poor, new HashSet());
            set.add(rich);
            map.put(poor, set);
        }

        int[] results = new int[quiet.length];
        Arrays.fill(results, -1);
        for (int i = 0; i < quiet.length; i++) {
            helper(map, quiet, results, i);
        }
        return results;
    }

    private int helper(Map<Integer, Set<Integer>> map, int[] quiet, int[] results, int currentPerson) {
        if (results[currentPerson] >= 0) return results[currentPerson];

        results[currentPerson] = currentPerson;
        if (!map.containsKey(currentPerson)) return results[currentPerson];
        for (int richer : map.get(currentPerson)) {
            int person = helper(map, quiet, results, richer);
            if (quiet[person] < quiet[results[currentPerson]]) results[currentPerson] = person;
        }
        return results[currentPerson];
    }
}