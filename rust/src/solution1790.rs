use crate::common::Solution;

impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        let mut total = 0;

        let mut result: [char; 4] = [' '; 4];

        let mut s1_array = s1.chars();
        let mut s2_array = s2.chars();
        for _ in 0..s1.len() {
            // trick -> nth will discard accessed value
            // e.g.  "abcde" -> nth(0) -> "bcde" -> nth(0) -> "cde"
            let c1 = s1_array.nth(0).expect("invalid index");
            let c2 = s2_array.nth(0).expect("invalid index");

            if c1 == c2 { continue; }

            total += 1;
            if total == 1 {
                result[0] = c1;
                result[1] = c2;
            } else if total == 2 {
                result[2] = c1;
                result[3] = c2;
            } else {
                return false
            }
        }

        if total == 0 { return true }
        if total == 2 && result[0] == result[3] && result[1] == result[2] { return true }
        false
    }
}