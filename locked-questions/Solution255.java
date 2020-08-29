public class Solution {
    // trick -> this code is not ac and might be wrong solution
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private boolean helper(int[] data, int start, int end) {
        if (data.length <= 1) return true;

        int root = data[start];
        int smallerIndex = start;
        int biggerIndex = end;
        for (int i = start + 1; i <= end; i++) {
            int each = data[i];
            if (each > data[i]) {
                biggerIndex = Math.min(biggerIndex, i);
            } else if (each < data[i]) {
                smallerIndex = Math.max(smallerIndex, i);
            } else {
                return false;
            }
        }
        if (smallerIndex >= biggerIndex) return false;
        boolean left = helper(data, start + 1, smallerIndex);
        if (left == false) return false;
        boolean right = helper(data, biggerIndex, end);
        if (right == false) return false;
        return true;
    }
}