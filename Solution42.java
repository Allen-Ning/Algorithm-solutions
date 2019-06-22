class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxLeft = -1;
        int maxRight = -1;
        int result = 0;
        while (start < end) {
            maxLeft = Math.max(maxLeft, height[start]);
            maxRight = Math.max(maxRight, height[end]);
            
            if (maxLeft <= maxRight) {
                result += maxLeft - height[start];
                start++;
            } else {
                result += maxRight - height[end];
                end--;
            }
        }
        return result;
    }
}
