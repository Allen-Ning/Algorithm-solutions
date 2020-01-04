class Solution {
    // [1,2,4,16,8,4]
    // sort: [1, 2, 4, 4, 8 ,16]
    // hashmap
    // 1 2 4 8 4
    // A[2 * i + 1] = 2 * A[2 * i]
    // A[1] = 2A[0]
    // A[3] = 2A[2]
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);

        HashMap<Integer, Integer> map = new HashMap();
        for (Integer num : A) map.put(num, map.getOrDefault(num, 0)  + 1);

        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) continue;
            Integer counter1 = map.get(A[i]);
            Integer lookup = A[i] > 0 ? 2 * A[i] : A[i] / 2;
            Integer counter2 = map.get(lookup);
            if (counter1 != null && counter2 != null && counter1 > 0 && counter2 > 0) {
                if (counter1 == 1) {
                    map.remove(A[i]);
                } else {
                    map.put(A[i], counter1 - 1);
                }

                if (counter2 == 1) {
                    map.remove(lookup);
                } else {
                    map.put(lookup, counter2 - 1);
                }

            } else {
                return false;
            }
        }
        return map.size() == 0;
    }
}
