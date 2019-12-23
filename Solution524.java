class Solution {
    public String findLongestWord(String s, List<String> d) {
      if (s == null || s.length() == 0 || d == null || d.size() == 0) return "";
      int max = 0;
      String result = "";
      for (String each : d) {
        int counter = 0;
        int index = 0;
        int size = each.length();
        for (int i = 0; i < s.length(); i++) {
          if (index == size) break;
          if (s.charAt(i) == each.charAt(index)) {
            counter++;
            index++;
          }
        }

        if (counter == size && counter > max) {
          max = counter;
          result = each;
        // trick -> be care compareTo may return less than -1 such as -4
        } else if (counter == size && counter == max && each.compareTo(result) < 0) {

          result = each;
        }
      }
      return result;
    }
}
