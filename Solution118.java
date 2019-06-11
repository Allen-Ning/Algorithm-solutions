class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows == 0) return result;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList();
            list.add(1);
            for (int j = 1; j <= i; j++) {
                List<Integer> aboveRow = result.get(i - 1);
                int value = 0;
                if (j - 1 >= 0) value += aboveRow.get(j - 1);
                if (j <= aboveRow.size() - 1) value += aboveRow.get(j);
                list.add(value);
            }
            result.add(list);
        }
        return result;
    }
}
