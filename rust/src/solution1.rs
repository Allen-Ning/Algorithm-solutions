
struct Solution {}

use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        let mut result = Vec::new();
        for i in 0..nums.len() {
            let value = target - nums[i];
            if map.contains_key(&value) {
                let &index = map.get(&value).expect("key exist");
                result.push(index);
                result.push(i as i32);
                return result;
            }
            map.insert( nums[i], i as i32);
        }

        return result
    }
}
