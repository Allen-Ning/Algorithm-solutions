class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] counter = new int[26];
        int[] counter2 = new int[26];
        for (String str: B) {
            counter2 = new int[26];
            for (char c : str.toCharArray()) {
                counter2[c - 'a'] += 1;
            }

            for (int i = 0; i < 26; i++) {
                counter[i] = Math.max(counter2[i], counter[i]);
            }
        }

        List<String> results = new ArrayList();
        for (String str : A) {
            counter2 = new int[26];
            for (char c : str.toCharArray()) {
                counter2[c - 'a'] += 1;
            }

            boolean isResult = true;
            for (int i = 0; i < 26; i++) {
                if (counter2[i] < counter[i]) {
                    isResult = false;
                    break;
                }
            }
            if (isResult) results.add(str);
        }
        return results;
    }
}
