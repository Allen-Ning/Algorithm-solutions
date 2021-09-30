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
    pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match root {
            None => false,
            Some(node) => {
                let current = Rc::try_unwrap(node).unwrap().into_inner();
                Self::helper(current.left, current.right)
            }
        }
    }

    fn helper(node1: Option<Rc<RefCell<TreeNode>>>, node2: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match (node1, node2) {
            (None,None) => true,
            (None, Some(_)) => false,
            (Some(_), None) => false,
            (Some(n1), Some(n2)) => {
                let current1 = Rc::try_unwrap(n1).unwrap().into_inner();
                let current2 = Rc::try_unwrap(n2).unwrap().into_inner();

                if current1.val != current2.val {
                    return false
                }

                Self::helper(current1.left, current2.right) &&
                Self::helper(current1.right, current2.left)
            },
        }
    }
}