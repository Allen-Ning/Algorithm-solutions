class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return new int[0];

        int[] result = new int[A.length];
        int low  = 0;
        int high = A.length - 1;
        int index = A.length - 1;
        while (low <= high) {
            if (Math.abs(A[low]) < Math.abs(A[high])) {
                result[index] = Math.abs(A[high]) * Math.abs(A[high]);
                high--;
            } else {
                result[index] = Math.abs(A[low]) * Math.abs(A[low]);
                low++;
            }
            index--;
        }
        return result;
    }
}
