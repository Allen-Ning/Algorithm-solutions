public class Solution {
  boolean hasCycle(ListNode head) {
    if (head = null) return false;
    ListNode slow = head.next;
    ListNode fast = head.next.next;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
       while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;

          if (slow == fast) return true;
        }
    }
    return false;
  }
}