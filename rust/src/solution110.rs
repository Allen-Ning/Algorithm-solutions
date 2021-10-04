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
use std::cmp;
impl Solution {
    pub fn is_balanced(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match Self::helper(root) {
            -1 => false,
            _ => true,
        }
    }

    fn helper(node: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        match node {
            None => 0,
            Some(n) => {
                let current = Rc::try_unwrap(n).unwrap().into_inner();
                let left_depth = Self::helper(current.left);
                let right_depth = Self::helper(current.right);
                if (left_depth - right_depth).abs() > 1 ||
                    left_depth == -1 ||
                    right_depth == -1
                {
                    return -1;
                }
                cmp::max(left_depth, right_depth) + 1
            }
        }
    }
}