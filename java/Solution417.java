class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> results = new ArrayList();
    if (matrix == null || matrix.length == 0) return results;

    Queue<int[]> queue = new LinkedList();
    Queue<int[]> queue2 = new LinkedList();
    boolean[][] isVisisted = new boolean[matrix.length][matrix[0].length];
    boolean[][] isVisisted2 = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      queue.offer(new int[]{i, 0});
      isVisisted[i][0] = true;

      queue2.offer(new int[]{i, matrix[0].length - 1});
      isVisisted2[i][matrix[0].length - 1] = true;
    }

    for (int j = 0; j < matrix[0].length; j++) {
      queue.offer(new int[]{0, j});
      isVisisted[0][j] = true;

      queue2.offer(new int[]{matrix.length - 1, j});
      isVisisted2[matrix.length - 1][j] = true;
    }

    bfs(queue, matrix, isVisisted);
    bfs(queue2, matrix, isVisisted2);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (isVisisted[i][j] && isVisisted2[i][j]) {
          List<Integer> list = new ArrayList();
          list.add(i);
          list.add(j);
          results.add(list);
        }
      }
    }
    return results;
  }

  private void bfs(Queue<int[]> queue, int[][] matrix, boolean[][] isVisisted) {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty()) {
      int size = queue.size();
      int[] current = queue.poll();
      for (int i = 0; i < size; i++) {
        for (int[] dir : dirs) {
          int newX = current[0] + dir[0];
          int newY = current[1] + dir[1];

          if (newX >= 0 &&
            newX < matrix.length &&
            newY >= 0 &&
            newY < matrix[0].length &&
            isVisisted[newX][newY] == false &&
            matrix[current[0]][current[1]] <= matrix[newX][newY]
          ) {
            isVisisted[newX][newY] = true;
            queue.offer(new int[]{newX, newY});
          }
        }
      }
    }
  }
}

