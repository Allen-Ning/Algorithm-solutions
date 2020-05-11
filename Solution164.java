class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int bucketNum = nums.length - 1;
        // trick -> max gap must be larger or equal than this gap
        int gap = (int) Math.ceil((double) (max - min) / bucketNum);
        int[] minValueBuckets = new int[bucketNum];
        int[] maxValueBuckets = new int[bucketNum];
        Arrays.fill(minValueBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxValueBuckets, Integer.MIN_VALUE);
        for (int num : nums) {
            int index = -1;
            if (num == min) {
                index = 0;
            } else if (num == max) {
                index = bucketNum - 1;
            } else {
                index = (num - min) / gap;
            }
            minValueBuckets[index] = Math.min(minValueBuckets[index], num);
            maxValueBuckets[index] = Math.max(maxValueBuckets[index], num);
        }

        int result = gap;
        int prev = maxValueBuckets[0];
        for (int i = 1; i < bucketNum; i++) {
            int current = minValueBuckets[i];
            if (current == Integer.MAX_VALUE) continue;
            result = Math.max(result, current - prev);
            prev = maxValueBuckets[i];
        }
        return result;
    }
}
