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
    pub fn is_same_tree(p: Option<Rc<RefCell<TreeNode>>>, q: Option<Rc<RefCell<TreeNode>>>) -> bool {
       return Self::helper(p, q)
    }

    fn helper(p: Option<Rc<RefCell<TreeNode>>>, q: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match (p, q) {
            (None, None) => true,
            (None, Some(_)) => false,
            (Some(_), None) => false,
            (Some(n1), Some(n2)) => {
                if n1.borrow().val != n2.borrow().val {
                    return false
                }

                let node1 =  Rc::try_unwrap(n1).unwrap().into_inner();
                let node2 = Rc::try_unwrap(n2).unwrap().into_inner();

                return Self::helper(node1.left, node2.left) && Self::helper( node1.right, node2.right)
            }
        }
    }
}