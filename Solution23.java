/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;
        while (currentNode != null) {
            ListNode minNode = null;
            int count = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) continue;
                if (minNode == null || node.val < minNode.val) {
                    minNode = node;
                    count = i;
                }
            }
            if (minNode != null && count >= 0) {
                lists[count] = minNode.next;
                minNode.next = null;
            }

            currentNode.next = minNode;
            currentNode = minNode;
        }
        return dummy.next;
        
    }
}
