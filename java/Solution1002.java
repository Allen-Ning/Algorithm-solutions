class Solution {
    public List<String> commonChars(String[] A) {
        int[] counter = new int[26];
        set(counter, A[0]);

        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            set(temp, A[i]);
            merge(counter, temp);
        }

        List<String> results = new ArrayList();
        for (int i = 0; i < 26; i++) {
            int value = counter[i];
            for (int j = 0; j < value; j++) {
                results.add(String.valueOf((char) (i + 'a')));
            }
        }
        return results;
    }

    private void set(int[] counter, String str) {
        for (int i = 0; i < str.length(); i++) counter[str.charAt(i) - 'a'] += 1;
    }

    private void merge(int[] counter, int[] temp) {
        for (int i = 0; i < counter.length; i++) counter[i] = Math.min(counter[i], temp[i]);
    }
}
