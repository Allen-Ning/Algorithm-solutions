public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 0) return 0;
        char[] data = (String.join("#", sentence) + "#").toCharArray();

        // trick -> the current index is not included in the cols
        // e.g  index = 8, means only the [0, 7] is the cols
        int index = 0;
        int currentRow = 0;

        while (currentRow < rows) {
            index += cols;
            char c = data[index % data.length];

            while (c != '#' && index > 0) {
                // trick -> check (index - 1) is smart cos this will keep index and c synced
                c = data[(index - 1) % data.length];
                index--;
            }

            if (c == '#') index++;
            currentRow++;
        }
        return index / data.length;
    }
}