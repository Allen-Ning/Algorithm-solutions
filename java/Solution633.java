class Solution {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        //  3 -> 4
        //  9 -> 16   
        //  15 -> 3.87
        int high = (int) Math.sqrt(c);
        while (low <= high) {
            int value = low * low + high * high;
            int target = c;
            if (value > target) {
                high -= 1;
            } else if (value == target) {
                return true;
            } else if (value < target) {
                low += 1;
            }
        }
        return false;
    }
}
