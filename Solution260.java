class Solution {
    // [1, 2, 1, 3, 2, 5]
    // a = 3
    // b = 5

    //      a 011
    // XOR  b 101
    //------------
    // diff   110
    //
    // real diff = diff & ~ (diff - 1) = 6 & (-5) = 110 & 010 = 010
    // from the most right bit to the most left bit, find the first bit from a, b are different
    // and set the rest bits to zero

    // put a, b into two bucket divided by diff

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= ~(diff - 1);

        int[] result = new int[2];
        for (int num: nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
