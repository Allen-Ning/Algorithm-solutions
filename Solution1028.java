/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        return helper(S, new int[] { 0 }, 0);
    }

    private TreeNode helper(String s, int[] current, int expecetdLevel) {
        int level = getLevel(s, current);
        // trick -> by checking level and expecetdLevel, we only need to scan string one time.
        //          dash means how many level they are.
        //          e.g. "1-2--3--4-5--6--7"
        //          by check dash we know, -2 and -5 are the same level, and --4 and -5 are in the different branch
        if (level != expecetdLevel) return null;
        int value = getValue(s, current, level);
        TreeNode node = new TreeNode(value);
        node.left = helper(s, current, expecetdLevel + 1);
        node.right = helper(s, current, expecetdLevel + 1);
        return node;
    }

    private int getValue(String s, int[] current, int level) {
        int index = current[0];
        index = index + level;
        int value = 0;
        for (int i = index; i < s.length(); i++) {
            current[0] = i;
            if (s.charAt(i) == '-') break;
            value = value * 10 + s.charAt(i) - '0';
        }
        return value;
    }

    private int getLevel(String s, int[] current) {
        int index = current[0];
        int level = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) != '-') break;
            level++;
        }
        return level;
    }
}