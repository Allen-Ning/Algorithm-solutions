class Solution {

    // Alough space complexity is O(2n), but I feel like this is more clear to understand (preferred way)
    // time complexisty O(n)
    // space complexisty O(2n)
    public int[] nextGreaterElements(int[] nums) {
        int[] doubleNums = new int[nums.length * 2];
        if (nums == null || nums.length == 0) return doubleNums;

        for (int i = 0; i < doubleNums.length; i++) {
            doubleNums[i] = (i < nums.length) ? nums[i] : nums[i - nums.length];
        }

        int[] results = new int[nums.length];
        Arrays.fill(results, -1);

        Stack<Integer> s = new Stack();
        for (int i = 0; i < doubleNums.length; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }

            int topIndex = s.peek();
            while (doubleNums[topIndex] < doubleNums[i]) {
                
                s.pop();
                if (topIndex < results.length) results[topIndex] = doubleNums[i];

                if (!s.isEmpty()) {
                    topIndex = s.peek();
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return results;
    }

    // Alough space complexity is O(n), but I feel like this may easily introduce bug
    // time complexisty O(n)
    // space complexisty O(n)
    public int[] nextGreaterElements2(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int[] results = new int[nums.length];
        Arrays.fill(results, -1);

        Stack<Integer> s = new Stack();
        for (int i = 0; i < 2 * nums.length; i++) {
            int currentIndex = i % nums.length;
            if (s.isEmpty()) {
                s.push(currentIndex);
                continue;
            }

            int topIndex = s.peek();
            while (nums[topIndex] < nums[currentIndex]) {
                s.pop();
                results[topIndex] = nums[currentIndex];

                if (!s.isEmpty()) {
                    topIndex = s.peek();
                } else {
                    break;
                }
            }
            s.push(currentIndex);
        }
        return results;
    }
}
