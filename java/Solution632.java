class Solution {
    public int[] smallestRange(List<List<Integer>> lists) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((num1, num2) -> num1[0] - num2[0]);

        int[] indexes = new int[lists.size()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            int value = lists.get(i).get(0);
            max = Math.max(max, value);
            minHeap.add(new int[] {value, i});
        }
        int[] result = new int[]{minHeap.peek()[0], max};

        while (minHeap.size() > 0) {
            int[] element = minHeap.poll();
            int min = element[0];
            int i = element[1];

            if (max - min < result[1] - result[0] || (((max - min) == (result[1] - result[0])) && min < result[0])) {
                result[0] = min;
                result[1] = max;
            }

            indexes[i] += 1;
            // trick -> we need to be careful about this if any of the array reaching ends
            // we don't need to do any check further cos we always remove the smallest one
            if (indexes[i] >= lists.get(i).size()) break;

            int nextValue = lists.get(i).get(indexes[i]);
            minHeap.add(new int[]{nextValue, i});
            max = Math.max(max, nextValue);
        }
        return result;
    }
}