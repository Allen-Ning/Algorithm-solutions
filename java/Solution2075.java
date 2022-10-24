class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int total = encodedText.length();
        int cols = encodedText.length() / rows;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            int x = i / cols;
            int y = i % cols;

            while (x < rows && y < cols) {
                sb.append(encodedText.charAt(x * cols + y));
                x += 1;
                y += 1;
            }
        }

        return sb.toString().stripTrailing();
    }
}