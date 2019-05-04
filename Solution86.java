/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode smallHead = new ListNode(0);
    ListNode bigHead = new ListNode(0);
    ListNode currentSmall = smallHead;
    ListNode currentBig = bigHead;
    ListNode current = head;
    while (current != null) {
      if (current.val < x) {
        currentSmall.next = current;
        currentSmall = currentSmall.next;
      } else {
        currentBig.next = current;
        currentBig = currentBig.next;
      }
      current = current.next;
    }

    currentBig.next = null;
    currentSmall.next = bigHead.next;
    return smallHead.next;
  }
}
