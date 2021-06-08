class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        // trick -> (at most k) - (at most k - 1) = exact k
        return atMost(A, K) - atMost(A, K - 1);
    }

    private int atMost(int[] A, int K) {
        int start = 0;
        int end = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap();
        while (end < A.length) {
            int current = A[end];
            map.put(current, map.getOrDefault(current, 0) + 1);
            while (map.size() > K) {
                int removedValue = A[start++];
                int counter = map.get(removedValue) - 1;
                if (counter == 0) {
                    map.remove(removedValue);
                } else {
                    map.put(removedValue, counter);
                }
            }

            // trick -> end - start + 1 will add each subarray ending with end to the result with at most k
            //          e.g.   0 1 2 3 4
            //                [1,2,1,2,3]
            //                start: 0, end: 3, k: 2 ->
            //                [2]
            //                [1,2]
            //                [2,1,2]
            //                [1,2,1,2]
            result += end - start + 1;
            end++;
        }
        return result;
    }
}
