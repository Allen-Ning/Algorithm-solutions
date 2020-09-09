/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList();
        for (NestedInteger nextedInteger : nestedList) queue.offer(nextedInteger);

        int total = 0;
        int base = 0;
        // trick ->  [1,[4,[6]]]
        //           1*3 + 4*2 + 6*1 = 17
        //           1 + (1 + 4) + (4 + 6 + 1)
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nextedInteger = queue.poll();
                if (nextedInteger.isInteger()) {
                    base += nextedInteger.getInteger();
                } else {
                    for (NestedInteger next : nextedInteger.getList()) queue.offer(next);
                }
            }
            total += base;
        }
        return total;
    }
}
