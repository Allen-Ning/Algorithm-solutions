class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    HashMap<String, Integer> map = new HashMap();
    HashSet<String> set = new HashSet();
    for (int i = 0; i + 9 < s.length(); i++) {
      String str = s.substring(i, i + 10);
      if (map.containsKey(str)) {
        set.add(str);
      } else {
        map.put(str, 1);
      }
    }
    return new ArrayList(set);
  }
}
