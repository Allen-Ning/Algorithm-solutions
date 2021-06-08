/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap();
        // trick -> dummy node is to handle special case [0, 0, 0, 0]
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        int value = 0;
        while (current != null) {
            value += current.val;
            map.put(value, current);
            current = current.next;
        }

        // 0 [1,2,3,-3,-2]
        // 0  1 3 6  3  1
        current = dummy;
        value = 0;
        while (current != null) {
            value += current.val;
            ListNode node = map.get(value);
            if (node != current) current.next = node.next;
            current = current.next;
        }
        return dummy.next;
    }
}
