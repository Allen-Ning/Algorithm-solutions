class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode nextNode = head.next;
        int size = 1;
        while (nextNode != null) {
            nextNode = nextNode.next;
            size += 1;
        }

        int move = k % size;
        if (move == 0) return head;
        int count = 1;
        ListNode current = head;
        ListNode change = null;
        ListNode preChange = null;
        while (current != null) {
            if (count == size - move) {
                preChange = current;
            } else if (count == size - move + 1) {
                change = current;
            }

            if (count == size) {
                current.next   = head;
                preChange.next = null;
                break;
            }

            current = current.next;
            count++;
        }
        return change;
    }
}