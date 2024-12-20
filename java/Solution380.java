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