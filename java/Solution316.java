class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter[c - 'a'] += 1; 
        }
        
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack();
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if (!used[s.charAt(i) - 'a']) {
                char cur = s.charAt(i);
                while (!stack.isEmpty() && stack.peek() > cur && counter[stack.peek() - 'a'] >= 1) {
                    int removedIndex = stack.pop() - 'a';
                    used[removedIndex] = false;
                }   
                stack.push(cur);
                used[s.charAt(i) - 'a'] = true;
            };
            counter[s.charAt(i) - 'a'] -= 1;
        }
        
        String str = "";
        while(!stack.isEmpty()) {
            str += stack.pop();
        }
        return new StringBuilder(str).reverse().toString();
    }
}
