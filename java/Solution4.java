class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int length = nums1.length + nums2.length;
        int l = -2;
        int h = nums1.length + 1;

        while (l + 1 != h) {
            int index1 = l + (h - l) / 2;
            int l1 = index1 < 0 ? Integer.MIN_VALUE : nums1[index1];
            int r1 = index1 + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[index1 + 1];

            // trick -> half = (length + 1) / 2
            //         e.g. [1, 2, 3, 4, 5]:    half = (5 + 1) / 2 = 3
            //         e.g. [1, 2, 3, 4, 5, 6]: half = (6 + 1) / 2 = 3
            int index2 = (length + 1) / 2  - (index1 + 1) - 1;
            int l2 = index2 < 0 ? Integer.MIN_VALUE : nums2[index2];
            int r2 = index2 + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[index2 + 1];
            if (l2 > r1) {
                l = index1;
            } else if (l1 > r2) {
                h = index1;
            } else {
                return getResult(length, l1, l2, r1, r2);
            }
        }
        return -1;
    }

    private double getResult(int length, int l1, int l2, int r1, int r2) {
        if (length % 2 == 0) {
            return ((double)Math.min(r1, r2) + (double)Math.max(l1, l2)) / 2;
        } else {
            return (double) Math.max(l1, l2);
        }
    }
}