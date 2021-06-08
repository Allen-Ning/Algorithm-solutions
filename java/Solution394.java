class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() <= 1) return s;
        Stack<Character> stack = new Stack(); 
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            char c = s.charAt(i);
            String part = "";
            if (c == ']') {
                c = stack.pop();
                while (c != '[') {
                    part += (c + "");
                    c = stack.pop();
                }

                char num = stack.pop();
                int number = 0;
                int counter = 0;
                while (num - '0' >= 0 && '9' - num >= 0) {
                    number = number + (int) ((num - '1' + 1) * Math.pow(10, counter));
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        num = stack.pop();
                    }   
                    counter++;
                }
                if (!(num - '0' >= 0 && '9' - num >= 0)) stack.push(num);
                StringBuilder sb = new StringBuilder(part);
                String revserPart = sb.reverse().toString();
                for (int j = 0; j < number; j++) {
                    str += revserPart;
                }
               
                for (int j = 0; j < str.length(); j++) {
                    stack.push(str.charAt(j));
                }
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
