struct Solution {}

impl Solution {
    pub fn count_matches(items: Vec<Vec<String>>, rule_key: String, rule_value: String) -> i32 {
        let index = Solution::get_index(&rule_key) as usize;

        let mut result = 0;
        for item in items {
            if item.get(index).expect("invalid index") != &rule_value { continue }
            result += 1;
        }
        return result;
    }

    fn get_index(rule_key: &str) -> i32 {
        return  match rule_key {
            "type" => 0,
            "color" => 1,
            "name" => 2,
            _ => -1,
        };
    }
}