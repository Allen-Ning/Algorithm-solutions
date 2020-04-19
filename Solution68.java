class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0;
        int width = 0;
        int actualWidth = 0;
        List<String> results = new ArrayList();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            width += word.length();
            actualWidth += word.length();
            if (width > maxWidth) {
                i -= 1;
                actualWidth -= word.length();
                results.add(createEvenly(words, start, i, maxWidth, actualWidth));
                start = i + 1;
                width = 0;
                actualWidth = 0;
            } else if (width == maxWidth && i != words.length - 1) {
                results.add(createEvenly(words, start, i, maxWidth, actualWidth));
                start = i + 1;
                width = 0;
                actualWidth = 0;
            } else if (width <= maxWidth && i == words.length - 1) {
                results.add(createLeftAlign(words, start, i, maxWidth));
            } else {
                width += 1;
            }
        }
        return results;
     }

    private String createEvenly(String[] words, int start, int end, int maxWidth, int actualWidth) {
        StringBuilder sb = new StringBuilder();
        int space = 0;
        int emptySlot = 0;
        if (start == end) {
            space = maxWidth - actualWidth;
            sb.append(words[end]);
            int temp = space;
            while (temp-- > 0) sb.append(" ");
            return sb.toString();
        } else {
            space = (maxWidth - actualWidth) / (end - start);
            emptySlot = (maxWidth - actualWidth) % (end - start);
        }
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            int temp = space;
            while (temp-- > 0) sb.append(" ");
            if (emptySlot-- > 0) sb.append(" ");
        }
        sb.append(words[end]);
        return sb.toString();
    }

    private String createLeftAlign(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (sb.length() < maxWidth) sb.append(" ");
        }
        while (sb.length() < maxWidth) sb.append(" ");
        return sb.toString();
    }
}
