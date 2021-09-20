// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}

use crate::common::Solution;

impl Solution {
    pub fn middle_node(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let cloned_head = head.clone();
        Self::helper(head, cloned_head)
    }

    fn helper(slow: Option<Box<ListNode>>, fast: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if fast.is_none() {
            return None;
        }

        let fast_node = fast?;
        let slow_node = slow?;

        if fast_node.next.is_none() {
            return Some(slow_node);
        }

        let fast_next_next = fast_node.next?.next;
        if fast_next_next.is_none() {
            return slow_node.next;
        }

        Self::helper(slow_node.next, fast_next_next)
    }
}