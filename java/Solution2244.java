class Solution {
    public int minimumRounds(int[] tasks) {
        // trick -> 
        // -------------------------------------------------------
        // 1 -> (3n + 1) -> return -1
        // 2 -> (3n + 2) ->  return n + 1
        // 3 -> 3n -> return 1
        // -------------------------------------------------------
        // 4 -> (3n + 1) -> 3 * (n - 1) + 2 + 2 = n - 1 + 2 = n + 1
        // 5 -> (3n + 2) -> 3 * n + 2 = n + 1
        // 6 -> 3n -> 3 * n = n
        // -------------------------------------------------------
        // 7 -> (3n + 1) -> n + 1
        // 8 -> (3n + 2) -> n + 1
        //--------------------------------------------------------

        // e.g.
        // [2,2,3,3,2,4,4,4,4,4]
        // [2, 2, 2, 3, 3, 4, 4, 4, 4]
        // map -> (2, 3)
        // map -> (3, 2)
        // map -> (4, 4)
        Map<Integer, Integer> map = new HashMap();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count == 1) return -1;

            if (count % 3 == 0) {
                result += count / 3;
            } else {
                result += count / 3 + 1;
            }
        }
        return result;
    }
}