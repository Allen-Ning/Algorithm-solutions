class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int num = A.length;
        List<Integer> results = new ArrayList();

        for (int i = num - 1; i >= 0; i--) {
            if (A[i] == num) {
                num--;
                continue;
            }
            int index = findLargestIndex(A, num);
            swop(A, 0, index);
            results.add(index + 1);

            swop(A, 0, num - 1);
            results.add(num);
            num--;
        }
        return results;
    }

    private void swop(int[] A, int i, int j) {
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    private int findLargestIndex(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) return i;
        }
        return -1;
    }
}
