class Solution {
    public int majorityElement(int[] nums) {
        // trick -> avoid to use hashmap
        int target = -1;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (counter == 0) {
                target = nums[i];
                counter = 1;
            } else if (num != target) {
                counter--;
            } else {
                counter++;
            }
        }
        return target;
    }
}