class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0) return true;

        boolean[][] map = new boolean[N+1][N+1];
        for (int i = 0; i < dislikes.length; i++) {
            int[] dislike = dislikes[i];
            map[dislike[0]][dislike[1]] = true;
            map[dislike[1]][dislike[0]] = true;
        }

        int[] checkedMap = new int[N + 1];
        for (int i = 1; i < checkedMap.length; i++) {
            if (!helper(map, checkedMap, i, checkedMap[i] == 0 ? 1 : checkedMap[i])) return false;
        }
        return true;
    }

    private boolean helper(boolean[][] map, int[] checkedMap, int start, int value) {
        if (checkedMap[start] == 0) {
            checkedMap[start] = value;
        } else if (checkedMap[start] == value) {
            return true;
        } else if (checkedMap[start] != value) {
           return false;
        }

        boolean[] isConnected = map[start];
        for (int i = 0; i < isConnected.length; i++) {
            if (!isConnected[i]) continue;
            if (!helper(map, checkedMap, i, value * -1)) return false;
        }
        return true;
    }
}
