class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) return num2;
        if (num2.length() == 0) return num1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >=0 || carry == 1; i--, j--) {
            int value1 = i < 0 ? 0 : (num1.charAt(i) - '0');
            int value2 = j < 0 ? 0 : (num2.charAt(j) - '0');
            sb.append((value1 + value2 + carry) % 10);
            carry = (value1 + value2 + carry) / 10; 
        }
        return sb.reverse().toString();
    }
}
