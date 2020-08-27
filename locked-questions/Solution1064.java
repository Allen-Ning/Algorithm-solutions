public class Solution {
    // please notice this code is not ac
    public int findMinIndex(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == i) return i;
        }
        return -1;
    }
}