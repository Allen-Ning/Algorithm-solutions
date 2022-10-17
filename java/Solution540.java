class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = -1;
        int end = nums.length;
        while (start + 1 != end) {
            int mid = start + (end - start) / 2;
            // trick -> e.g. mid = odd 
            //
            //                            0  1  2
            //                           [1, 1, 2]
            //
            //               mid = even
            //                           0  1  2  3  4
            //                          [1, 1, 2, 2, 3]
            //
            // trick -> mid < nums.length - 1
            //                     e.g.              
            //                             0
            //                            [1]
            //
            //                           0  1  2
            //                          [1, 1, 2]
            // 
            // trcik -> no need to check mid > 0 && mid % 2 == 1 && nums[mid] == nums[mid - 1]
            //          cos there is alway nums[mid - 1] existing
            if ((mid < nums.length - 1 && mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1]) 
               )
                start = mid;
            else {
                end = mid;
            }
        }
        return nums[end];
    }
}