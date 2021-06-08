class Solution {
    class Element {
        int value;
        int status;
        public Element(int value, int status) {
            this.value = value;
            this.status = status;
        }
    }

    public int shortestPathLength(int[][] graph) {
        Queue<Element> queue = new LinkedList();
        int check = 1;
        for (int i = 0; i < graph.length; i++) {
            check |= 1 << i;
            int status = 1 << i;
            Element e = new Element(i, status);
            queue.offer(e);
        }

        int step = 0;
        int total = graph.length;
        boolean[][] isVisisted = new boolean[total][check + 1];
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Element current = queue.poll();
                if ((current.status & check) == check) return step;
                for (int next : graph[current.value]) {
                    int nextStatus = current.status | (1 << next);
                    if (isVisisted[next][nextStatus]) continue;
                    isVisisted[next][nextStatus] = true;
                    Element nextE = new Element(next, nextStatus);
                    queue.offer(nextE);
                }
            }
            step++;
        }
        return 0;
    }
}
