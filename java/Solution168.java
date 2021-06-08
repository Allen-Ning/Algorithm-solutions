// mapping the base
// 1 -> A
// 2 -> B
// 3 -> C
// 26 -> Z
// 27 -> AA
// 28 -> AB

// 0 -> A
// 1 -> B
// 2 -> C
// 25 -> Z
// 26 -> AA
// 27 -> AB

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1 ) / 26;
        }
        return sb.reverse().toString();
    }
}
