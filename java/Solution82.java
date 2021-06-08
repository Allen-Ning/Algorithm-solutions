/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    boolean isReaptedNode = false;
    while (current != null) {
      if (current.next != null && current.val == current.next.val) {
        current.next = current.next.next;
        isReaptedNode = true;
      } else {
        if (isReaptedNode) {
          prev.next = current.next;
          current = prev.next;
        } else {
          prev = current;
          current = current.next;
        }
        isReaptedNode = false;
      }
    }
    return dummy.next;
  }
}
