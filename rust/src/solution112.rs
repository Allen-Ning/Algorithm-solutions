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
    pub fn has_path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        Self::helper(root, &target_sum, 0)
    }

    fn helper(node: Option<Rc<RefCell<TreeNode>>>, target_sum: &i32, sum: i32) -> bool {
        match node {
            None => false,
            Some(n) => {
                let current = Rc::try_unwrap(n).unwrap().into_inner();

                if current.left.is_none() &&
                   current.right.is_none() &&
                   sum + current.val == *target_sum
                {
                    return true
                }

                Self::helper(current.left, target_sum, sum + current.val) ||
                Self::helper(current.right, target_sum, sum + current.val)
            },
        }
    }
}
