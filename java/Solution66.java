class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;

            digits[i] = digit;
            if (carry == 0) return digits;
        }

        int[] result = new int[digits.length + 1];
        if (carry == 1) result[0] = 1;
        return result;
    }
}