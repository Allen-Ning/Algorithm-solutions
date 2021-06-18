class Solution {
    public String similarRGB(String color) {
        char[] codes = color.toCharArray();
        HashMap<Character, Integer> values = new HashMap();
        values.put('0', 0);
        values.put('1', 1);
        values.put('2', 2);
        values.put('3', 3);
        values.put('4', 4);
        values.put('5', 5);
        values.put('6', 6);
        values.put('7', 7);
        values.put('8', 8);
        values.put('9', 9);
        values.put('a', 10);
        values.put('b', 11);
        values.put('c', 12);
        values.put('d', 13);
        values.put('e', 14);
        values.put('f', 15);

        StringBuilder sb = new StringBuilder("#");
        for (int i = 1; i < codes.length; i += 2) {
            sb.append(nearestColor(values, codes[i], codes[i + 1]));
        }
        return sb.toString();
    }

    private String nearestColor(HashMap<Character, Integer> values, char c1, char c2) {
        int value = getValue(values, c1, c2);
        StringBuilder sb = new StringBuilder();
        String result = null;
        // trick -> we have to use int[] to replace Integer type
        //          due to the fact Integer will always assign to a new object when using = operator
        //          e.g
        //          Integer a = 1;
        //          System.out.println(System.identityHashCode(a));
        //          a = 2;
        //          System.out.println(System.identityHashCode(a));
        //          a = 1;
        //          System.out.println(System.identityHashCode(a));
        //          -----------------------------------------------
        //          output:
        //          1175962212
        //          918221580
        //          1175962212

        int[] gap = new int[] { Integer.MIN_VALUE };
        calc(value, getValue(values, c1, c1), gap, c1, c1, sb);
        calc(value, getValue(values, c2, c2), gap, c2, c2, sb);
        calc(value, getValue(values, prevChar(c1), prevChar(c1)), gap, prevChar(c1), prevChar(c1), sb);
        calc(value, getValue(values, nextChar(c1), nextChar(c1)), gap, nextChar(c1), nextChar(c1), sb);
        return sb.toString();
    }

    private int getValue(HashMap<Character, Integer> values, char c1, char c2) {
        if (c1 == '*' || c2 == '*') return Integer.MAX_VALUE;
        return values.get(c1) * 16 + values.get(c2);
    }
    
    private char nextChar(char c) {
        if (c == 'f') return '*';
        if (c == '9') return 'a';
        return (char) (c + 1);
    }

    private char prevChar(char c) {
        if (c == '0') return '*';
        if (c == 'a') return '9';
        return (char) (c - 1);
    }

    private void calc(int value1, int value2, int[] gap, char c1, char c2, StringBuilder sb) {
        if (value2 == Integer.MAX_VALUE) return;

        int value = -1 * (value1 - value2) * (value1 - value2);
        if (value > gap[0]) {
            gap[0] = value;
            sb.setLength(0);
            sb.append(c1);
            sb.append(c2);
        }
    }
}