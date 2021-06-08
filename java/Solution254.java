public class Solution {
    public List<List<Integer>> getFactors(int n) {
        Set<List<Integer>> set = new HashSet();
        List<List<Integer>> results = new ArrayList();
        helper(set, results, new ArrayList<Integer>(), n);
        return results;
    }

    // trick -> two tricks needs to be done to avoid duplication
    //          1. limit max to Math.sqrt(n) -> [2, Math.sqrt(n)]
    //          2. keep increasing order druing dfs loop such as [2 * 2 * 3] rather than [2 * 3 * 2] or [3 * 2 * 2]
    private void helper(Set<List<Integer>> set, List<List<Integer>> results, List<Integer> result, int n) {
        if (n == 1) {
            if (result.size() <= 1) return;
            List<Integer> potentialResult = new ArrayList<Integer>(result);
            if (set.add(potentialResult)) results.add(potentialResult);
        }

        int min = 2;
        // trick -> the min value for this round will be the value from last round to avoid final results including duplication
        //          to keep the increasing order, we will avoid some duplication as method1
        //          e.g for 12, one duplication could be 2 * 2 * 3 | 2 * 3 * 2 | 3 * 2 * 2, 3 (3 possible combinations)
        //          to avoid duplication, we can only keep 2 * 2 * 3
        if (result.size() != 0) min = result.get(result.size() - 1);
        for (int i = min; i <= Math.sqrt(n); i++) {
            if (n % i != 0) continue;
            result.add(i);
            helper(set, results, result, n / i);
            result.remove(result.size() - 1);
        }

        // trick -> this is to make sure to reach the return condition n == 1
        //          e.g for 8, the first round will be min: 2, max: Math.squrt(8) as method2
        //                  4 is not included to avoid some duplication 2 * 4 and 4 * 2
        //            2
        //          8 -> 4
        //            8
        //          8 -> 1
        result.add(n);
        helper(set, results, result, 1);
        result.remove(result.size() - 1);
    }
}
