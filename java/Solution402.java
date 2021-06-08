class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return num;

        Stack<Character> s = new Stack();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (k > 0 && !s.isEmpty() && c < s.peek()) {
                s.pop();
                k--;
            }
            s.push(c);
        }

        while (k > 0) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        sb.reverse();
        boolean isLeadZero = true;
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString().length() == 0 ? "0" : sb.toString();
    }
} 
