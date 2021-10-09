// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}
use crate::common::Solution;
use std::rc::Rc;
use std::cell::RefCell;
use std::vec;
impl Solution {
    pub fn binary_tree_paths(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<String> {
        let mut results = vec![];
        Self::helper(root, &mut results, &mut vec![]);
        results
    }

    fn helper(node: Option<Rc<RefCell<TreeNode>>>, results: &mut Vec<String>, result: &mut Vec<String>){
        match node {
            None => (),
            Some(n) => {
                let current = Rc::try_unwrap(n).unwrap().into_inner();

                if current.left.is_none() && current.right.is_none() {
                    result.push(current.val.to_string());
                    results.push(result.join(""));
                } else {
                    result.push(current.val.to_string() + "->");
                }

                Self::helper(current.left, results, result);
                Self::helper(current.right, results, result);
                result.remove(result.len() - 1);
            }
        }
    }
}