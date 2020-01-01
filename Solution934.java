class Solution {
    public int shortestBridge(int[][] A) {
        boolean isFound = false;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) continue;
                helper(queue, A, i, j);
                isFound = true;
                break;
            }
            if (isFound) break;
        }

        // trick -> using bfs to find the shortest path from one of the departure to
        //          one of the destination
        int counter = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] visited = queue.poll();
                for (int[] dir : dirs) {
                    int newX = dir[0] + visited[0];
                    int newY = dir[1] + visited[1];
                    if (newX >= 0 &&
                        newX < A.length &&
                        newY >= 0 &&
                        newY < A[0].length
                    ) {
                      if (A[newX][newY] == 0) {
                          queue.offer(new int[] {newX, newY});
                          A[newX][newY] = 2;
                      } else if (A[newX][newY] == 1) {
                          return counter;
                      }
                        
                    } 
                }
            }
            counter++;
        }
        return -1;
    }

    private void helper(Queue<int[]> queue, int[][] A, int x, int y) {
        if (x < 0 || 
            x >= A.length || 
            y < 0 ||
            y >= A[0].length ||
            A[x][y] != 1
           ) return;
        
        A[x][y] = 2;
        queue.offer(new int[]{x, y});

        helper(queue, A, x + 1, y);
        helper(queue, A, x - 1, y);
        helper(queue, A, x, y - 1);
        helper(queue, A, x, y + 1);
    }
}
