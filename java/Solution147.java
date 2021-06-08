/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 4 <- 2  <-1      3
    //           head       cur
    // 2 -> 4
    // head
    // 1 -> 2 -> 4
    // 1 -> 2 -> 3 -> 4
    ListNode dummyHead = new ListNode(0);
    public ListNode insertionSortList(ListNode head) {
        // 4 -> 2 -> 1 -> 3
        // 4    2 -> 1 -> 3
        // cur  next
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = null;
            addNodeToNewList(current);
            current = next;
        }
        return dummyHead.next;   
    }
    
    private void addNodeToNewList(ListNode toBeAddedNode) {
        ListNode current = dummyHead.next;
        ListNode pre = dummyHead;
        // clean way to find the place to insert node
        while (current != null && current.val < toBeAddedNode.val) { 
            pre = current;
            current = current.next;
        }
        pre.next = toBeAddedNode;
        toBeAddedNode.next = current;
    }
}
