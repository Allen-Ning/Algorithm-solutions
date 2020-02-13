class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int l = 0;
        int r = costs.length - 1;
        int mid = costs.length / 2 - 1;
        int target = mid;
        // 0 1 2 3
        // 4 - 3  -1
        while (l < r) {
            int index = partition(costs, l, r);
            if (index == target) break;
            if (index > target) {
                r = index - 1;
            } else {
                l = index + 1;
                // trick -> this line is not needed
                //          we can directly check against our returned index
                // target = target - index - 1;
            }
        }

        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            if (i <= mid) {
                total += cost[0];
            } else {
                total += cost[1];
            }
        }
        return total;
    }

    private int partition(int[][] costs, int l, int r) {
        int s = l - 1;
        int f = l;
        int p = r;
        while (s < r && f < r) {
            if (getValue(costs[f]) >= getValue(costs[p])) {
                f++;
            } else {
                swop(costs, s+1, f);
                s++;
                f++;
            }
        }

        swop(costs, p, s + 1);
        return s + 1;
    }

    private void swop(int[][] costs, int c1, int c2) {
        int[] temp = costs[c1];
        costs[c1] = costs[c2];
        costs[c2] = temp;
    }

    private int getValue(int[] cost) {
        return cost[0] - cost[1];
    }
}
