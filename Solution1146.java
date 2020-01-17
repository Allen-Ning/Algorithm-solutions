class SnapshotArray {

    // trick -> for each index, we using treeMap to records all the changes for specific index 
    //          by using this, we only care about changes and save lots of memory 
    TreeMap<Integer, Integer>[] map;
    int snap_id;

    public SnapshotArray(int length) {
        this.snap_id = 0;
        this.map = new TreeMap[length];
    }

    public void set(int index, int val) {
        if (map[index] == null) map[index] = new TreeMap<Integer, Integer>();
        map[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        if (map[index] == null) return 0;
        // trick -> hard to remember exactly api function name
        //          floorEntry might also return null
        Map.Entry<Integer, Integer> entry = map[index].floorEntry(snap_id);
        if (entry == null) return 0;
        return entry.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
