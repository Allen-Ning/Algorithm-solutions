class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, int[]> map = new HashMap();
        Map<String, Integer> checkedMap = new HashMap();

        int day = 0;
        String key = generateKey(cells);
        while (!checkedMap.containsKey(key)) {
            checkedMap.put(key, day);
            map.put(day, cells);
            cells = nextCells(cells);
            key = generateKey(cells);
            day++;
        }

        int loop = day - checkedMap.get(key);
        int offSet = checkedMap.get(key);
        // trick -> the loop might be introduced after some iterations
        //          be careful when calculating result index by using some examples
        return map.get(offSet + (N - offSet) % loop);
    }

    private String generateKey(int[] cells) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++) sb.append(cells[i]);
        return sb.toString();
    }

    private int[] nextCells(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            if (i == 0 || i == cells.length - 1) {
                next[i] = 0;
                continue;
            }

            if ((cells[i - 1] ^ cells[i + 1]) == 0) {
                next[i] = 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}
