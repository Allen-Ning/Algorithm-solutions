class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;

        int[] frequencies = new int[26];
        for (int task: tasks) frequencies[task - 'A'] += 1;

        int maxFrequency = 0, maxFreqencyCount = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > maxFrequency) {
                maxFrequency = frequencies[i];
                maxFreqencyCount = 1;
            } else if (frequencies[i] == maxFrequency) {
                maxFreqencyCount++;
            }
        }
        int expectedResult = (maxFrequency - 1) * (n + 1) + maxFreqencyCount;
        return Math.max(expectedResult, tasks.length);
    }
}
