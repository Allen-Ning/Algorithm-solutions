/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode node = root;
        while (node != null) {
          node = node.next;
          size++;
        }

        ListNode[] results = new ListNode[k];
        node = root;
        int groupSize = (size / k == 0 ? 1 : (size / k));
        int eachGroup = 0;
        int extra = 0;
        int extraElements = 0;
        if (size / k > 0) {
            extraElements = size % k;
            if (extraElements != 0) extra = 1;
        }
        int groupCount = 0;
        int index = 0;
        ListNode next = null;
        while (index < size) {
          if (groupCount >= extraElements) extra = 0;

          next = node.next;
          // trick -> If element is first element in eachGroup, add it in to results 
          if (eachGroup == 0) results[groupCount] = node;
          eachGroup++;

          // trick -> If element is the last element in eachGroup, set the next of node to null
          if (eachGroup == (groupSize + extra)) {
            node.next = null;
            eachGroup = 0;
            groupCount++;
          }

          node = next;
          index++;
        }
        return results;
    }
}
