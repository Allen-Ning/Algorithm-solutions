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
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
     let mut result = vec![];
     Self::helper(root, &mut result);
     result
    }

    fn helper(node: Option<Rc<RefCell<TreeNode>>>, result: &mut Vec<i32>) {
        match node {
            None =>(),
            Some(n) => {
                let current = Rc::try_unwrap(n).unwrap().into_inner();
                Self::helper(current.left, result);
                result.push(current.val);
                Self::helper(current.right, result);
            }
        }
    }
}