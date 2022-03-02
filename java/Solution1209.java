class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Element> stack = new Stack();

        char letter = s.charAt(0);
        stack.push(new Element(letter, 1));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            Element element = null;
            if (stack.size() > 0) element = stack.peek();

            if (element == null || c != element.c) {
                stack.push(new Element(c, 1));
                continue;
            }

            if (element.counter < k - 1) {
                element.counter += 1;
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            Element element = stack.pop();
            for (int i = 0; i < element.counter; i++) sb.append(element.c);            
        }

        return sb.reverse().toString();
    }

    class Element {
        char c;
        int counter;
        
        public Element(char c, int counter) {
            this.c = c;
            this.counter = counter;
        }
    }
}