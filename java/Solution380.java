class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        Integer index = map.get(val);
        int last = list.get(list.size() - 1);

        // trick -> To achieve O(1) deletion from an ArrayList, swap the target
        // element with the last element, then remove the last element.
        //
        // This approach works for all cases:
        //   - [7, 9] delete 9 -> 9 is already last, just remove it
        //   - [9]    delete 9 -> single element, just remove it
        //   - [9, 7] delete 9 -> swap 9 with 7, then remove last

        // trick -> don't forget to update both list and map for val and last
        list.set(index, last);
        // trick -> we need to update the last element index
        map.put(last, index);

        map.remove(val);
        // trick -> forget api how to remove last in arraylist
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        // trick -> this random syntax nextInt(num) -> [0, num)
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */