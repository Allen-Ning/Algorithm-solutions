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

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        helper(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
        if (r > l) return;
        if (l > n) return;
        if (r > n) return;

        if (l == n && r == n) {
            result.add(sb.toString());
            return;
        }

        helper(n, l + 1, r, sb.append("("), result);
        // trick -> syntax
        sb.deleteCharAt(sb.length() - 1);
        helper(n, l, r + 1, sb.append(")"), result);
        sb.deleteCharAt(sb.length() - 1);
    }
}