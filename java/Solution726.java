class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap();
        // trick -> we need to save treemap in stack to store prev state
        Stack<TreeMap<String, Integer>> stack = new Stack();
        String current = "";
        int value = 0;
        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                addValue(map, current, value);
                current = String.valueOf(c);

                // trick -> reset temp values
                value = 0;
            } else if (c >= 'a' && c <= 'z') {
                current += String.valueOf(c);
            } else if (c >= '0' && c <= '9') {
                value = value * 10 + c - '0';
            } else if (c == '(') {
                addValue(map, current, value);
                stack.push(map);

                // trick -> reset temp values
                map = new TreeMap();
                current = "";
                value = 0;
            } else if (c == ')') {
                addValue(map, current, value);

                int num = 0;
                while (++i < formula.length()) {
                    c = formula.charAt(i);
                    if (c < '0' || c > '9') break;
                    num = num * 10 + c - '0';
                }
                if (i < formula.length()) i--;
                // trick -> when encounter ), we need to * num + add prev map (poping from stack) into it
                //          xx(ab(cd)2) -> when parsing cd -> (cd * 2) + ab
                addPrevValueFromStack(stack, map, num);

                // trick -> reset temp values
                current = "";
                value = 0;
            }
            i++;
        }

        addValue(map, current, value);
        return getResult(map);
    }

    private void addValue(TreeMap<String, Integer> map, String current, int value) {
        if (value == 0) value = 1;
        if (current.length() > 0) map.put(current, map.getOrDefault(current, 0) + value);
    }

    private void addPrevValueFromStack(Stack<TreeMap<String, Integer>> stack, TreeMap<String, Integer> map, int num) {
        for (String key : map.keySet()) map.put(key, map.get(key) * num);
        TreeMap<String, Integer> temp;
        if (stack.size() != 0) {
            temp = stack.pop();
            for (String key : temp.keySet()) map.put(key, map.getOrDefault(key, 0) + temp.get(key));
        }
    }

    private String getResult(TreeMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1 )sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
