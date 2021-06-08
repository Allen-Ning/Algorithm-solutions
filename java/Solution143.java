/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public void reorderList(ListNode head) {
    if (head == null) return;
    ListNode mid = findMiddleNode(head);

    // reverse the mid
    // 1 -> 2 -> 3 <- 4
    // 1 -> 2 -> 3 <- 4 <- 5
    ListNode end = reverse(mid);


    ListNode node = head;
    while (node != mid && end != mid) {
      ListNode next = node.next;
      ListNode endNext = end.next;
      node.next = end;
      end.next = next;
      node = next;
      end = endNext;
    }

  }

  private ListNode findMiddleNode(ListNode node) {
    ListNode slow = node;
    ListNode fast = node;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode node) {
    ListNode pre = null;
    ListNode current = node;
    ListNode next = current.next;
    while(current != null) {
      next = current.next;
      current.next = pre;

      pre = current;
      current = next;

    }
    return pre;

  }
}
