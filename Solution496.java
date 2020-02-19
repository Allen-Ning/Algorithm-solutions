class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        // trick -> loop through nums2 instead of nums1
        //          kicking off the values in stack if they are less then the current value
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (stack.size() != 0 && nums2[i] > stack.peek()) stack.pop();
            map.put(nums2[i], stack.size() > 0 ? stack.peek() : -1);
            stack.push(nums2[i]);
        }

        int[] results = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) results[i] = map.get(nums1[i]);
        return results;
    }
}
