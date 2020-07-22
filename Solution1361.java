class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // find the root
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) return false;

        boolean[] isVisited = new boolean[n];
        helper(isVisited, root, leftChild, rightChild);
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i]) continue;
            return false;
        }
        return true;
    }

    private int findRoot(int n, int[] leftChild, int[] rightChild) {
        int[] childrenNodes = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            int value1 = leftChild[i];
            int value2 = rightChild[i];

            if (value1 != -1) childrenNodes[value1] += 1;
            if (value2 != -1) childrenNodes[value2] += 1;
        }

        int counter = 0;
        int root = -1;
        for (int i = 0; i < childrenNodes.length; i++) {
            if (childrenNodes[i] > 1) return -1;
            if (childrenNodes[i] == 1) continue;
            if (counter == 1) return -1;

            root = i;
            counter++;
        }
        return root;
    }

    private void helper(boolean[] isVisited, int node, int[] leftChild, int[] rightChild) {
        if (node == -1 || isVisited[node]) return;

        isVisited[node] = true;
        helper(isVisited, leftChild[node], leftChild, rightChild);
        helper(isVisited, rightChild[node], leftChild, rightChild);
    }
}
