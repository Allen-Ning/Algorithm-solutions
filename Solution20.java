class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']' || c == '}' || c == ')') {
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
