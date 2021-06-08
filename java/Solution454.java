class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;

        for (int i = 0; i < A.length; i++) {
          for (int j = 0; j < B.length; j++) {
            int value = A[i] + B[j];
            map.put(value, map.getOrDefault(value, 0) + 1);
          }
        }

        for (int i = 0; i < C.length; i++) {
          for (int j = 0; j < D.length; j++) {
            int value = (C[i] + D[j]) * (-1);
            result += map.getOrDefault(value, 0);
          }
        }
        return result;
    }
}
