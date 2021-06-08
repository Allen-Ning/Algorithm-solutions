class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int counter = 1;
        int start = clips[0][0];
        int end = clips[0][1];
        if (start != 0) return -1;
        if (end >= T) return counter;

        for (int i = 1; i < clips.length; i++) {
            int[] clip = clips[i];
            int currentStart = clip[0];
            int currentEnd = clip[1];

            if (currentEnd <= end) {
                continue;
            } else if (currentEnd > end && currentStart <= end) {
                int j = i + 1;
                // trick -> this is for check the next avaible end
                //          e.g [0, 4]
                //              [2, 5]
                //              [4, 8]
                //          we would like to skip [2, 5] and find the largest end
                while (j < clips.length && clips[j][0] <= end) {
                    currentEnd = Math.max(currentEnd, clips[j][1]);
                    j++;
                }
                i = j - 1;
                end = currentEnd;
                counter++;
            } else if (currentStart > end) {
                return -1;
            }
            if (end >= T) return counter;
        }
        return -1;
    }
}
