class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) return 0;
        Map<Integer, Integer>[] maps = new HashMap[A.length];

        int result = 2;
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                int dif = A[i] - A[j];
                if (!maps[i].containsKey(dif)) maps[i].put(dif, 2);
                if (maps[j].get(dif) != null) maps[i].put(dif, maps[j].get(dif) + 1);

                result = Math.max(maps[i].get(dif), result);
            }
        }
        return result;
    }
}
