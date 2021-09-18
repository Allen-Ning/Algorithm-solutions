// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

use crate::common::Solution;

impl Solution {
    pub fn merge_two_lists(mut l1: Option<Box<ListNode>>, mut l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        return Self::helper(l1, l2);
    }

    fn helper(mut l1: Option<Box<ListNode>>, mut l2: Option<Box<ListNode>>) -> Option<Box<ListNode>>{
        if l1.is_none() { return l2; }

        if l2.is_none() { return l1; }

        let mut l1_current = l1?;
        let mut l2_current = l2?;

        if l1_current.val < l2_current.val {
            l1_current.next = Self::helper(l1_current.next, Some(l2_current));
            Some(l1_current)
        } else {
            l2_current.next = Self::helper(Some(l1_current), l2_current.next);
            Some(l2_current)
        }
    }
}
