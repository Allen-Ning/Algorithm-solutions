class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<int[]> queue = new LinkedList();
        List<Integer> result = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            queue.offer(new int[] {i, i + 1});
        }

        while (queue.size() > 0) {
            int[] current = queue.poll();
            if (current[0] > high) continue;

            // trick -> only add value to result when value is larger than lower value
            if (current[0] >= low) result.add(current[0]);

            // trick -> be care the biggest number is 9.
            //          e.g. xxxx9
            if (current[1] > 9) continue;

            queue.offer(new int[] {
                current[0] * 10 + current[1],
                current[1] + 1
            });
        }
        return result;
    }
}