class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List<Integer> result = new ArrayList();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    result.add(1);
                    continue;
                }

                result.add(results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
            }
            results.add(result);
        }
        return results;
    }
}