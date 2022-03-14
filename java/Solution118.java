class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> prevResult = new ArrayList();
        prevResult.add(1);
        results.add(prevResult);

        int row = 2;
        while (row <= numRows) {
            List<Integer> currentResult = new ArrayList();
            currentResult.add(prevResult.get(0));
            for (int i = 1; i < row - 1; i++) {
                currentResult.add(prevResult.get(i - 1) + prevResult.get(i));
            }
            currentResult.add(prevResult.get(prevResult.size() - 1));
            results.add(currentResult);
            prevResult = currentResult;
            row++;
        }
        return results;
    }
}