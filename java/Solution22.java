class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList();
        helper(results, n, 0, 0, "");
        return results;
    }

    private void helper(List<String> results, int n, int left, int right, String str) {
        if (left < right || left > n || right > n) return;
        if (left == n && right == n) {
            results.add(str);
            return;
        }

        helper(results, n, left + 1, right, str + "(");
        helper(results, n, left, right + 1, str + ")");       
    }
}