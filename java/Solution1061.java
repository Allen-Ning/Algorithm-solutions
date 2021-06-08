class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] result = new int[] { 0 };
        helper(requests, new int[n], 0, 0, result);

        return result[0];
    }

    private void helper(int[][] requests, int[] buildings, int current, int counter, int[] result) {
        if (current == requests.length) {
            if (isBalance(buildings) && counter > result[0]) {
                result[0] = counter;
            }
            return;
        }

        // with request
        int[] request = requests[current];
        int from = request[0];
        int to = request[1];
        buildings[from]--;
        buildings[to]++;
        helper(requests, buildings, current + 1, counter + 1, result);
        buildings[to]--;
        buildings[from]++;

        // without request
        helper(requests, buildings, current + 1, counter, result);
    }

    private boolean isBalance(int[] buildings) {
        for (int building : buildings) {
            if (building != 0) return false;
        }
        return true;
    }
}