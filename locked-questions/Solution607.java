public class TwoSum {
    Map<Integer, Integer> map = new HashMap();

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int check = value - key;
            if (check == key && map.get(key) >= 2) {
                return true;
            } else if (check != key && map.containsKey(check)) {
                return true;
            }
        }
        return false;
    }
}