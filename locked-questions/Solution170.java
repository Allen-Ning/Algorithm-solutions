public class TwoSum {
    Map<Integer, Integer> map = new HashMap();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }


    // TODO this is not the best solution
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