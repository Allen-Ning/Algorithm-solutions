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
impl Solution {
    pub fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut result = 0;
        Self::helper(root, &mut result, 1);
        return result;
    }

    fn helper(node: Option<Rc<RefCell<TreeNode>>>, result: &mut i32, level: i32) {
        match node {
            None => (),
            Some(n) => {
                let current = Rc::try_unwrap(n).unwrap().into_inner();
                Self::helper(current.left, result, level + 1);
                if level > *result {
                    *result = level;
                }
                Self::helper(current.right, result, level + 1);

            }
        }
    }
}