class Solution1 {

    HashMap<Integer, Integer> map;
    public TwoSum() {
        this.map = new HashMap();
    }

    // o (1)
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // o (n)
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            int lookUp = value - key;
            if (lookUp == key) {
                if (count < 2) continue;

                return true;
            }

            if (map.containsKey(lookUp)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */