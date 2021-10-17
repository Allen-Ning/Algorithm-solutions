use crate::common::Solution;

impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        // slow indexes indicating non zero values, but not including the current index
        let mut slow = 0;
        let mut fast = 0;

        while fast < nums.len() {
            if nums[fast] == 0 {
                fast += 1;
                continue;
            }

            nums[slow] = nums[fast];
            slow += 1;
            fast += 1;
        }

        while slow < nums.len() {
            nums[slow] = 0;
            slow += 1;
        }
    }
}