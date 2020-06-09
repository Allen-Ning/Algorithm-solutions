class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack();
        int i = 0;
        while (i < code.length()) {
            // trick -> make sure everything is within a tag all the time
            //          such as <tag>xxxxxxx</tag>
            if (i > 0 && stack.isEmpty()) return false;

            // trick -> the order of if-else does matter - <![CDATA[ -> </ -> <
            // trick -> startsWith will make us easy without couting by using substring(i, i + num)
            if (code.startsWith("<![CDATA[", i)) {
                // trick -> indexOf will make us easy to search
                int endIndex = code.indexOf("]]>", i);
                if (endIndex == -1) return false;
                i = endIndex + 2;
            } else if (code.startsWith("</", i)) {
                int endIndex = code.indexOf(">", i);
                if (endIndex == -1) return false;
                String tagName = code.substring(i + 2, endIndex);
                if (!isValidTag(tagName)) return false;
                if (stack.isEmpty() || !stack.peek().equals(tagName)) return false;
                stack.pop();
                i = endIndex;
            } else if (code.startsWith("<", i)) {
                int endIndex = code.indexOf(">", i);
                if (endIndex == -1) return false;
                String tagName = code.substring(i + 1, endIndex);
                stack.push(tagName);
                i = endIndex;
            }
            i++;
        }
        // trick -> this is to make sure all the tags have closing tag at the end
        //          e.g. check <tag>xxx will return false
        if (stack.size() > 0) return false;
        return true;
    }

    private boolean isValidTag(String tagName) {
        if (tagName.length() == 0 || tagName.length() > 9) return false;
        for (int i = 0; i < tagName.length(); i++) {
            char c = tagName.charAt(i);
            if (c < 'A' || c > 'Z') return false;
        }
        return true;
    }
}
