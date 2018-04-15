import java.util.ArrayList;
import java.util.List;

class Solution22 {

    private int total = 0;
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution22 s3 = new Solution22();
        s3.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        total = 2 * n;
        add( "",0, 0);
        return list;
    }

    private void add(String str, int openBracket, int closeBracket) {
        if (openBracket + closeBracket >= total) {
            list.add(str);
            return;
        }

        if (openBracket < total / 2) { add(str + "(", openBracket + 1, closeBracket); }

        if (closeBracket < openBracket) { add(str + ")", openBracket, closeBracket + 1); }
    }
}
