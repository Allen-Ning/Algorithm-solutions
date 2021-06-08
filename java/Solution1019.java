/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;
            list.add(node.val);
            node = next;
        }

        Stack<Integer> stack = new Stack();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (stack.size() == 0) {
                stack.push(i);
                continue;
            }

            while (stack.size() > 0 && list.get(i) > list.get(stack.peek())) {
                int index = stack.pop();
                result[index] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
