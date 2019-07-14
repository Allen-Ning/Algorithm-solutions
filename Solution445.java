/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (node1 != null) {
            s1.push(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            s2.push(node2.val);
            node2 = node2.next;
        }

        int carrier = 0;
        ListNode dummy = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty() || carrier != 0) {
            int value = 0;
            if (!s1.isEmpty()) value += s1.pop();
            if (!s2.isEmpty()) value += s2.pop();
            int reminder = (value + carrier) % 10;
            carrier = (value + carrier) / 10;
            ListNode node = new ListNode(reminder);
            ListNode next = dummy.next;
            dummy.next = node;
            node.next = next;
        }
        return dummy.next;
    }
}
