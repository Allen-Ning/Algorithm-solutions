/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode nodeA = headA;
        while (lengthA > lengthB) {
            nodeA = nodeA.next;
            lengthA--;
        }
        ListNode nodeB = headB;
        while (lengthA < lengthB) {
            nodeB = nodeB.next;
            lengthB--;
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
    
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }    
}
