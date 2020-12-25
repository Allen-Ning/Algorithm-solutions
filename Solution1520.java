class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<int[]> results = new ArrayList();

        // letters, [min, max] indexes
        int[][] positions = new int[26][2];
        for (int i = 0; i < positions.length; i++) {
            positions[i][0] = Integer.MAX_VALUE;
            positions[i][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            positions[c - 'a'][0] = Math.min(positions[c - 'a'][0], i);
            positions[c - 'a'][1] = Math.max(positions[c - 'a'][1], i);
        }

        for (int i = 0; i < 26; i++) {
            if (positions[i][0] == Integer.MAX_VALUE ||
                positions[i][1] == Integer.MIN_VALUE
            ) continue;

            int minIndex = positions[i][0];
            int maxIndex = positions[i][1];

            boolean isValid = true;
            for (int j = minIndex; j <= maxIndex; j++) {
                char c = s.charAt(j);
                // trick -> invalid case
                //          e.g. abcaxxx when checking letter c (index 2), a (index 3) is invalid cos there is another a (index 0)
                if (positions[c - 'a'][0] < minIndex) {
                    isValid = false;
                    break;
                }
                maxIndex = Math.max(maxIndex, positions[c - 'a'][1]);
            }
            if (isValid) results.add(new int[] {minIndex, maxIndex});
        }

        // trick -> we need to remove some included values
        //          e.g. abcba (abcba, bcb, c), only c will be kept for results
        //          results values cannot be overlapped cos we extend values by start and end indexes for each letter
        Collections.sort(results, (a, b) -> (a[1] - b[1]));
        List<String> filteredResults = new ArrayList();
        int[] prev = results.get(0);
        filteredResults.add(s.substring(prev[0], prev[1] + 1));
        for (int i = 1; i < results.size(); i++) {
            int[] current = results.get(i);
            if (current[0] <= prev[0] && prev[1] <= current[1]) continue;
            filteredResults.add(s.substring(current[0], current[1] + 1));
            prev = current;
        }
        return filteredResults;
    }
}