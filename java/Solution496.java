class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        Stack<Integer> stack = new Stack();
        int[] nextGreater = new int[nums2.length];

        Arrays.fill(nextGreater, -1);
        // next greater -> decreasing stack
        // trick -> loop through nums2 instead of nums1
        //          kicking off the values in stack if they are less then the current value
        for (int i = 0; i < nums2.length; i++) {
            while (stack.size() > 0 && nums2[stack.peek()] < nums2[i]) {
                nextGreater[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            result[i] = nextGreater[index] == -1 ? -1 : nums2[nextGreater[index]];
        }
        return result;
    }
}
