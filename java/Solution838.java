class Solution {
    // notice:
    // All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. 
    // The testcases will be generated such that the replacements will not overlap.
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] indexes = new int[s.length()];
        Arrays.fill(indexes, -1);

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            String source = sources[i];

            if (s.substring(index, Math.min(index + source.length(), s.length())).equals(source)) indexes[index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if (index == -1) {
                sb.append(s.charAt(i));
                continue;
            }
            sb.append(targets[index]);
            i += sources[index].length() - 1;
        }
        return sb.toString();
    }
}