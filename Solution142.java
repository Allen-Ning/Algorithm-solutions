//                  a        b 
//         start ------->-------->meeting
//                      |         |
//                      <----------
//                           c
//         assume fast and slow meets at k steps
//         k=a+b+r1(b+c) slow runs r1 cycles
//         2k=a+b+r2(b+c) fast runs r2 cycles
//         2k=a+b+r2(b+c)=2a+2b+2r1(b+c)
//         (b+c)(r2-2r1)=a+b => (b+c)n=a+b
//         a=(n-1)b+nc=(n-1)(b+c)+c which means when slow moves (n-1) cycles and c, start moves a

public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        fast = head;
        break;
      }
    }

    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
      if (slow == fast) {
        return slow;
      }
    }
    return null;
  }
}
