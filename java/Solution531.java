class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                char c = picture[i][j];
                if (c != 'B') continue;

                rows[i] += 1;
                cols[j] += 1;
            }
        }

        int result = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                char c = picture[i][j];

                if (c != 'B') continue;
                if (rows[i] == 1 && cols[j] == 1) result += 1;
            }
        }

        return result;
    }
}