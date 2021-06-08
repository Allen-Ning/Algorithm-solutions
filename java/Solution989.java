class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        String str = String.valueOf(K);
        List<Integer> results = new ArrayList();
        for (int i = A.length - 1; i >= 0; i--) {
            int value = K % 10;
            K /= 10;
            int result = A[i] + value;
            if (result / 10 > 0) K++;
            results.add(result % 10);
        }

        while (K > 0) {
            results.add(K % 10);
            K /= 10;
        }
        Collections.reverse(results);
        return results;
    }
}
