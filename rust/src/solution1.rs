use crate::common::Solution;
use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        let mut result = Vec::new();

        let length = nums.len();
        for i in 0..length {
            let num = nums[i];
            let lookup_num = target - num;
            match map.get(&lookup_num) {
                None => {
                    map.insert(num, i as i32);
                }
                Some(index) => {
                    result.push(*index);
                    result.push(i as i32);
                    return result;
                }
            }
        }
        return result;
    }
}
