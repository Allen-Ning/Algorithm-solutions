class NumMatrix {

    FenwickTree[] trees;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        trees = new FenwickTree[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            // trick -> we need to set n + 1 for elements
            //          first element starting from index 1
            trees[i] = new FenwickTree(matrix[i].length + 1);
            for (int j = 0; j < matrix[i].length; j++) {
                trees[i].update(j + 1, matrix[i][j]);
            }
            
        }
    }

    public void update(int row, int col, int val) {
        FenwickTree tree = trees[row];
        tree.update(col + 1, val - matrix[row][col]);
        // trick -> also needs to update the matrix as well
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            FenwickTree tree = trees[i];
            sum += tree.query(col2 + 1) - tree.query(col1);
        }
        return sum;
    }

    class FenwickTree {

        int[] data;
        public FenwickTree(int n) {
            this.data = new int[n];
        }

        // trick -> i & (-i) is the lowbit
        public int query(int i) {
            int sum = 0;
            // trick -> when sum, the condition is i > 0
            while (i > 0) {
                sum += data[i];
                // trick -> we need to use i -= i & (-i) when sum
                i -= i & (-i);
            }
            return sum;
        }

        public void update(int i, int value) {
            // trick -> when update, the condition is i < data.length
            while (i < data.length) {
                data[i] += value;
                // trick -> we need to use i += i & (-i) when update
                i += i & (-i);
            }
        }
    }
}
