/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int monitoredNoCam = 0;
    int monitoredWithCam = 1;
    int noMonitored = 2;

    public int minCameraCover(TreeNode root) {
        int[] result = new int[] {0};
        int status = helper(root, result);
        return result[0] + (status == noMonitored ? 1 : 0);
    }

    private int helper(TreeNode node, int[] result) {
        if (node == null) return monitoredNoCam;

        int left = helper(node.left, result);
        int right = helper(node.right, result);
        if (left == noMonitored || right == noMonitored) {
            result[0] += 1;
            return monitoredWithCam;
        } else if (left == monitoredNoCam && right == monitoredNoCam) {
            // trick -> we try to set the monitor as less as possible
            return noMonitored;
        } else {
            // trikc -> only two scenario could be here
            //          1. left, right = monitoredWithCam
            //          2. one is monitoredNoCam, one is monitoredWithCam
            //          both of return monitoredNoCam
            return monitoredNoCam;
        }
    }
}
