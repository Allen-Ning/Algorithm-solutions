class Solution {
    public String addBinary(String a, String b) {
        /**
            current bit a
            current bit b
            carry value

            newValue = (a + b + carry) % 2
            nextCarryValue = (a + b + carry) / 2
         */
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (index1 >= 0 || index2 >= 0 || carry > 0) {
            int total = carry;

            if (index1 >= 0) total += a.charAt(index1) - '0';
            if (index2 >= 0) total += b.charAt(index2) - '0';

            int value = total % 2;
            carry = total / 2;
            sb.append(value);

            index1--;
            index2--;
        }
        return sb.reverse().toString();
    }
}