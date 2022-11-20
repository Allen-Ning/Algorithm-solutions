class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList();
        boolean[][] isVisited = new boolean[n][n];
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(".");
        for (int i = 0; i < n; i++) result.add(sb.toString());

        helper(results, result, isVisited, 0, n);
        return results;
    }
    
    private void helper(List<List<String>> results, 
                        List<String> result, 
                        boolean[][] isVisited, 
                        int row, 
                        int n
    ) {
        if (row >= n) {
            List<String> finalResult = new ArrayList(result);
            results.add(finalResult);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(isVisited, row, col)) continue;
            isVisited[row][col] = true;
            StringBuilder sb = new StringBuilder(result.get(row));
            sb.setCharAt(col, 'Q');
            result.set(row, sb.toString());
            helper(results, result, isVisited, row + 1, n);
            sb.setCharAt(col, '.');
            result.set(row, sb.toString());
            isVisited[row][col] = false;
        }
    }

    private boolean isValid(boolean[][] isVisited, int row, int col) {
        int n = isVisited[0].length;
        // trick - no need to check left right cos we only add a queen per row
        //         no need to check bottom left and bottom right cos there is no queens added
        // check up down
        for (int i = 0; i < n; i++) {
            if (isVisited[i][col] && i != row) return false; 
        }

        int i = row;
        int j = col;

        // check top right
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (isVisited[i--][j++] && i != row && j != col) return false;
        }

        i = row;
        j = col;

        // check top left
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (isVisited[i--][j--] && i != row && j != col) return false;
        }
        return true;
    } 
}