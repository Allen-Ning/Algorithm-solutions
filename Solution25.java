/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        return reverseK(head, k);
    }

    private ListNode reverseK(ListNode node, int k) {
        if (node == null) return null;

        ListNode head = node;
        int counter = 1;
        boolean hasK = false;
        while (node != null) {
            if (counter == k) {
                hasK = true;
                break;
            }
            node = node.next;
            counter++;
        }

        if (!hasK) return head;
        ListNode tail = node;

        ListNode newHead = reverseK(node.next, k);
        reverse(head, tail);

        ListNode temp = head;
        head = tail;
        tail = temp;

        tail.next = newHead;
        return head;
    }

    //      1 -> 2 -> 3 -> 4 -> 5
    // pre  c   next
    // 1 -> 2 -> 3 -> 4 -> 5
    // pre  c   next
    // 1 <- 2 -> 3 -> 4 -> 5
    //      pre  c   next
    private void reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            if (cur == tail) break;
            pre = cur;
            cur = next;
        }
    }
}
