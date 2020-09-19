public class Solution {
    /**
     * @param workers: workers' location
     * @param bikes: bikes' location
     * @return: assign bikes
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] buckets = new List[2000];

        // [workerId, bikeId]
        // trick -> we need to loop workerIds and then bikeIds
        //          so that we satisfy smaller workerId, bikeId will be picked first to meet the requirements below
        //          1. If there are multiple (worker, bike) pairs with the same shortest Manhattan distance,
        //          we choose the pair with the smallest worker index;
        //          2. If there are multiple ways to do that, we choose the pair with the smallest bike index)
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = cal(workers[i], bikes[j]);
                List<int[]> bucket = buckets[distance];
                if (bucket == null) bucket = new ArrayList();
                bucket.add(new int[] {i, j});
                buckets[distance] = bucket;
            }
        }

        int[] results = new int[workers.length];
        boolean[] visitedWorkers = new boolean[workers.length];
        boolean[] visitedBikes = new boolean[bikes.length];

        // trick -> bucket count to reduce time complexsity to o(n)
        for (int i = 0; i < buckets.length; i++) {
            List<int[]> bucket = buckets[i];
            if (bucket == null) continue;

            for (int[] pair : bucket) {
                if (visitedWorkers[pair[0]] || visitedBikes[pair[1]]) continue;
                int workerId = pair[0];
                int bikeId = pair[1];
                results[workerId] = bikeId;
                visitedWorkers[workerId] = true;
                visitedBikes[bikeId] = true;
            }
        }
        return results;
    }

    private int cal(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}