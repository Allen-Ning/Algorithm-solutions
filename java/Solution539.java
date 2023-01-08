class Solution {
    // tag: bucket sort
    public int findMinDifference(List<String> timePoints) {
        int totalMins = 24 * 60;
        int[] slots = new int[totalMins];
        for (int i = 0; i < timePoints.size(); i++) {
            String timePoint = timePoints.get(i);
            String[] timeInfo = timePoint.split(":");
            int mins = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
            slots[mins] += 1;
            if (slots[mins] > 1) return 0;
        }

        int result = totalMins;
        int first = totalMins;
        int last = -1;
        int prev = -1;
        for (int i = 0; i < slots.length; i++) {
            int current = i;
            if (slots[current] == 0) continue;

            first = Math.min(first, current);
            last = Math.max(last, current);
            if (prev != -1) result = Math.min(result, current - prev);

            prev = current;
        }

        // trick -> this is to check the corner case
        //          e.g. ["23:59","00:00"]
        result = Math.min(result, first + totalMins - last);

        return result;
    }
}