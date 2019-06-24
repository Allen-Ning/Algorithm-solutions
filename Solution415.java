class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) return num2;
        if (num2.length() == 0) return num1;
        int carry = 0;
        while (num1.length() < num2.length()) {
            num1 =  "0" + num1; 
        }
        while (num1.length() > num2.length()) {
            num2 = "0" + num2; 
        }
      
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);
            int value = ((c1 - '0') + (c2 - '0') + carry) % 10;
            carry = ((c1 - '0') + (c2 - '0') + carry) / 10;
            
            sb.append(value);
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
