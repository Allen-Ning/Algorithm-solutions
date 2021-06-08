class Solution {
    class Element {
        int x;
        int y;
        int value;

        public Element(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int j = 0; j < heightMap[0].length; j++) {
            minHeap.offer(new Element(0, j, heightMap[0][j]));
            minHeap.offer(new Element(heightMap.length - 1, j, heightMap[heightMap.length - 1][j]));
            visited[0][j] = true;
            visited[heightMap.length - 1][j] = true;
        }

        for (int i = 0; i < heightMap.length; i++) {
            minHeap.offer(new Element(i, 0, heightMap[i][0]));
            minHeap.offer(new Element(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
            visited[i][0] = true;
            visited[i][heightMap[0].length - 1] = true;
        }

        // bfs
        int result = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (minHeap.size() > 0) {
            Element current = minHeap.poll();

            for (int[] dir : dirs) {
                int x = current.x + dir[0];
                int y = current.y + dir[1];
                if (x >= 0 &&
                    x < heightMap.length &&
                    y >= 0 &&
                    y < heightMap[0].length &&
                    !visited[x][y]
                   ) {
                    if (heightMap[x][y] < current.value) result += current.value - heightMap[x][y];
                    minHeap.offer(new Element(x, y, Math.max(heightMap[x][y], current.value)));
                    visited[x][y] = true;
                }
            }
        }
        return result;
    }
}
