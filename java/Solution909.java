class Solution {
    public int snakesAndLadders(int[][] board) {
      if (board == null || board.length == 0) return 0;
      int row = board.length;
      int col = board[0].length;
      int[] data = new int[row * col + 1];
      int index = 1;
      // trick -> we cannot pass test based on even or odd for current i
      //          and have to use a boolean to switch it
      boolean isReversed = false;
      for (int i = board.length - 1; i >= 0; i--) {
          if (!isReversed) {
            for (int j = 0; j < board[0].length; j++) data[index++] = board[i][j];
            isReversed = true;
          } else {
            for (int j = board[0].length - 1; j >= 0; j--) data[index++] = board[i][j];
            isReversed = false;
          }
      }

      Queue<Integer> queue = new LinkedList();
      queue.offer(1);

      boolean[] isVisited = new boolean[data.length];
      isVisited[0] = true;
      isVisited[1] = true;
      int step = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int current = queue.poll();
          for (int j = 1; j <= 6; j++) {
            index = current + j;
            if (index < data.length && data[index] > -1) {
                isVisited[index] = true;
                index = data[index];
            }

            if (index < data.length && !isVisited[index]) {
                isVisited[index] = true;
                queue.offer(index);
                if (index == data.length - 1) return step + 1;
            }
          }
        }
        step++;
      }
      return -1;
    }
}
