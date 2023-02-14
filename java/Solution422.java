class Solution {
    public boolean validWordSquare(List<String> words) {
        int rowNum = words.size();
        int i = 0;
        while (i < rowNum) {
            String row = words.get(i);
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i >= word.length()) break;

                sb.append(word.charAt(i));
            }

            String col = sb.toString();
            if (!row.equals(col)) return false;
            i++;
        }
        return true;
    }
}