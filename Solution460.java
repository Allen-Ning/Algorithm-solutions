class LFUCache {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> frequence;
    HashMap<Integer, LinkedHashSet<Integer>> valueWithSameFrequency;
    int min = 1;
    int capacity = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.frequence = new HashMap();
        this.valueWithSameFrequency = new HashMap();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int currentFrequence = frequence.get(key);
        int nextFrequence = currentFrequence + 1;
        frequence.put(key, nextFrequence);
        
        valueWithSameFrequency.get(currentFrequence).remove(key);
        if (currentFrequence == min && valueWithSameFrequency.get(currentFrequence).size() == 0) min++;
        if (valueWithSameFrequency.containsKey(nextFrequence)) {
            valueWithSameFrequency.get(nextFrequence).add(key);
        } else {
            LinkedHashSet<Integer> set = new LinkedHashSet();
            set.add(key);
            valueWithSameFrequency.put(nextFrequence, set);
        }

        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (!map.containsKey(key)) {

            if (map.size() == capacity) {
                int removedKey = valueWithSameFrequency.get(min).iterator().next();
                valueWithSameFrequency.get(min).remove(removedKey);
                map.remove(removedKey);
                frequence.remove(removedKey);
            }

            map.put(key, value);
            frequence.put(key, 1);
            LinkedHashSet<Integer> set;
            if (valueWithSameFrequency.containsKey(1)) {
                valueWithSameFrequency.get(1).add(key);
            } else {
                set = new LinkedHashSet();
                set.add(key);
                valueWithSameFrequency.put(1, set);
            }
            min = 1;
            return;
        }

        int currentFrequence = frequence.get(key);
        int nextFrequence = frequence.get(key) + 1;
        frequence.put(key, nextFrequence);
        map.put(key, value);
        valueWithSameFrequency.get(currentFrequence).remove(key);
        if (currentFrequence == min && valueWithSameFrequency.get(currentFrequence).size() == 0) min++;

        if (valueWithSameFrequency.containsKey(nextFrequence)) {
            valueWithSameFrequency.get(nextFrequence).add(key); 
        } else {
            LinkedHashSet<Integer> set = new LinkedHashSet();
            set.add(key);
            valueWithSameFrequency.put(nextFrequence, set);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
