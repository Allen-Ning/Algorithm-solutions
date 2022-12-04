class Solution {
    public int numRabbits(int[] answers) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            int num = key + 1;
            result += value - value % num;
            if (value % num > 0) result += num;
        }
        return result;
    }
}