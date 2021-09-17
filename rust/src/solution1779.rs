use crate::common::Solution;

impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        let mut result = -1;
        let mut distance = std::i32::MAX;
        for i in 0..points.len() {
            let current = &points[i];
            if current[0] != x && current[1] != y {
                continue;
            }

            let current_distance = (current[0] - x).abs() + (current[1] - y).abs();
            if current_distance < distance {
               distance = current_distance;
               result = i as i32;
            }
        }
        return result;
    }
}