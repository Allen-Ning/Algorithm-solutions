class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        Stack<Integer> stack = new Stack();
        int last = Integer.MIN_VALUE;
        // trick -> we need to check from the back to the front
        //          due to those two are adjacent so that we can use stack to 
        //          easily find the largest number and the second largest number pair
        //          If we try to find from the start tot the end,
        //          we will have to find the middle number, which will be trivial to implemnt
        for (int i = nums.length - 1; i >= 0; i--) {
            // trick -> [-3, 2,-2, 1, 2]
            //          we can to find the largest ascending nums starting the end of array
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                last = Math.max(last, stack.pop());
            }
            stack.push(nums[i]);

            if (nums[i] < last) return true;
        }
        return false;
    }
}
