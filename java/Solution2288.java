class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isPrice(word)) {
                double price = convertPrice(word) * ((double) (100 - discount) / 100);
                // trick -> syntax String.format("%.2f", price)
                sb.append("$" + String.format("%.2f", price));
                if (i < words.length - 1) sb.append(" ");
                continue;
            }
            sb.append(word);
            if (i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    private boolean isPrice(String word) {
        if (word.length() < 2) return false;
        if (!word.startsWith("$")) return false;

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c > '9' || c < '0') return false;
        }
        return true;
    }

    private long convertPrice(String word) {
        long price = 0;
        for (int i = 1; i < word.length(); i++) {
            price = price * 10 + (word.charAt(i) - '0');
        }
        return price;
    }
}