class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
      map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
      TreeMap<Integer, String> sortedMap = map.getOrDefault(key, new TreeMap<Integer, String> ());
      sortedMap.put(timestamp, value);
      map.put(key, sortedMap);
    }

    public String get(String key, int timestamp) {
      TreeMap<Integer, String> sortedMap = map.getOrDefault(key, new TreeMap<Integer, String> ());
      Map.Entry<Integer, String> entry = sortedMap.floorEntry(timestamp);
      if (entry != null) return entry.getValue();
      return "";
    }
}
