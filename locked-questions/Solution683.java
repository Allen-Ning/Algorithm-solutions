public class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        // trick -> we need to setup the bucket as k + 1, so that no pairs in the same bucket are potential result
        int bucketSize = k + 1;
        int size = flowers.length / bucketSize;
        if (flowers.length % bucketSize > 0) size += 1;
        int[] minBucket = new int[size];
        int[] maxBucket = new int[size];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < flowers.length; i++) {
            int location = flowers[i] - 1;
            int index = location / bucketSize;

            // trick -> if the location is min value in the current bucket, we need to check the left bucket
            if (location < minBucket[index]) {
                minBucket[index] = location;
                if (index > 0 && minBucket[index] - maxBucket[index - 1] == k + 1) return i + 1;
            }

            // trick -> if the location is max value in the current bucket, we need to check the right bucket
            if (location > maxBucket[index]) {
                maxBucket[index] = location;
                if (index < size - 1 && minBucket[index + 1] - maxBucket[index] == k + 1) return i + 1;
            }
        }
        return -1;
    }
}