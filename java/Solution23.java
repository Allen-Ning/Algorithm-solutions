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
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));

        // heapify the lists
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.offer(lists[i]);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) queue.offer(node.next);
            currentNode.next = node;
            currentNode = node;
        }
        return dummy.next;
    }
}
