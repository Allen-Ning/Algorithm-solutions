/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode current = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = null;
        ListNode end = null;

        while (current != null) {
            if (count == m) {
                start = current;
            } else if (count == (m -1)) {
                pre = current;
            }
            
            if (count == n) {
                end = current;
                break;
            }
            current = current.next;
            count++;
        }
        
        while (start != end) {
            ListNode insertedNode = start;
            pre.next = insertedNode.next;
            insertedNode.next = end.next;
            end.next = insertedNode;

            start = pre.next;
        }
        return dummy.next;
    }
}

