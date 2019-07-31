class RandomizedCollection {

    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList();
        map = new HashMap();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set;
        boolean result;
        if (map.containsKey(val)) {
            set = map.get(val);
            result = false;
        } else {
            set = new HashSet();
            result = true;
        }
        set.add(list.size() - 1);
        map.put(val, set);

        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> set = map.get(val);
        
        int toBeRemovedIndex = set.iterator().next();
        int lastIndexFromList = list.size() - 1;
        int lastVal = list.get(lastIndexFromList);
        
        // trick - this order is very important
        // must remove from set first, and then add it back to lastVal set
        // otherwise, it will failed by doing the other way around
        // e,g 3, 3, 3
        set.remove(toBeRemovedIndex);
        map.get(lastVal).add(toBeRemovedIndex);
        map.get(lastVal).remove(lastIndexFromList);
        list.set(toBeRemovedIndex, lastVal);
        list.remove(lastIndexFromList);
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 *kkkkkkkkkkkkkkkkkkkkkkkkkkk/
