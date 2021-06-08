class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;

        String[] lines = input.split("\n");
        Stack<String> stack = new Stack();
        int currentLength = 0;
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("\t");
            int counterT = parts.length - 1;
            // trick -> we can use stack size to kow how many level there are
            while (!stack.isEmpty() && counterT <= stack.size() - 1) {
                String popedStr = stack.pop();
                currentLength -= (popedStr.length() + 1);
            }
            stack.push(parts[parts.length - 1]);
            currentLength += (parts[parts.length - 1].length() + 1);
            if (parts[parts.length - 1].contains(".")) max = Math.max(currentLength - 1, max);
        }
        return max;
    }
}
