class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        int counter = 1;
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (String each : S.trim().split(" ")) {
            StringBuilder sb = null;
            char c = each.charAt(0);
            if (set.contains(c)) {
                sb = new StringBuilder(each);
            } else {
                sb = new StringBuilder(each.substring(1));
                sb.append(c);                
            }
            sb.append("ma");
            int index = 0;
            while (index < counter) {
                sb.append("a");
                index++;
            }
            result.append(sb.toString() + " ");
            counter++;
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}
