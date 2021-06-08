class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet();
        set.add(getKey(x, y));
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'W') {
                x--;
            } else if (c == 'E') {
                x++;
            }
            if (!set.add(getKey(x, y))) return true;
        }
        return false;
    }

    private String getKey(int x, int y) {
        return x + "-" + y;
    }
}
