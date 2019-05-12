/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    ListNode head;
    Random r = new Random();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
      this.head = head; 
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
      int count = 1;
      ListNode current = head;
      int value = head.val;
      while (current != null) {
        int index = r.nextInt(count);
        if (index == 0) {
          value = current.val;
        }
        count++;
        current = current.nex;
      }

      return value;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
