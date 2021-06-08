class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int current = startFuel;
        int result = 0;
        List<int[]> stationsIncludingTarget = new ArrayList();
        for (int[] station : stations) stationsIncludingTarget.add(station);
        stationsIncludingTarget.add(new int[] {target, 0});

        int currentLocation = 0;
        for (int[] station : stationsIncludingTarget) {
            int mile = station[0];
            int feul = station[1];
            while (pq.size() > 0 && current + currentLocation < mile) {
                int[] stationWithMaxPetrol = pq.poll();
                current += stationWithMaxPetrol[1];
                result++;
            }
            if (current + currentLocation < mile) return -1;

            current -= (mile - currentLocation);
            currentLocation = mile;
            pq.add(station);
        }
        return result;
    }
}
