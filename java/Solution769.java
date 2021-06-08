class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int max = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) counter++; 
        }
        return counter++;
    }
}
