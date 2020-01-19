class MyHashMap {

    class Element {
        int key;
        int value;

        public Element(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList[] map;
    int size = 10000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (map[key % size] == null) {
            map[key % size] = new LinkedList<Element>();
            map[key % size].add(new Element(key, value));
            return;
        }

        LinkedList<Element> list = map[key % size];
        for (Element e : list) {
            if (e.key == key) {
                e.value = value;
                return;
            }
        }
        map[key % size].add(new Element(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (map[key % size] == null) return -1;

        LinkedList<Element> list = map[key % size];
        for (Element e : list) {
            if (e.key == key) return e.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (map[key % size] == null) return;

        LinkedList<Element> list = map[key % size];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
