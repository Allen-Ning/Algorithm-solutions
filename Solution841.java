class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        helper(rooms, isVisited, 0);
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) return false;
        }
        return true;
    }

    private void helper(List<List<Integer>> rooms, boolean[] isVisited, int current) {
        if (isVisited[current]) return;

        isVisited[current] = true;
        for (int key : rooms.get(current)) helper(rooms, isVisited, key);
    }
}
