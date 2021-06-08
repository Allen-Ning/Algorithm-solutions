import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

// binary search - https://www.geeksforgeeks.org/collections-binarysearch-java-examples/
class Solution {
    public boolean isSubsequence(String s, String t) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int index = 0; index < t.length(); index++) {
            char letter = t.charAt(index);
            ArrayList<Integer> list = map.get(letter);
            if (list == null) {
              list = new ArrayList<>();
              list.add(index);
              map.put(letter, list);
            } else {
              list.add(index);
            }
        }

        ArrayList<Integer> list;
        int minIndex = Integer.MIN_VALUE;
        for (int index = 0; index < s.length(); index++) {
          list = map.get(s.charAt(index));
          if (list == null) return false;
          int result = Collections.binarySearch(list, minIndex);
          if (result < 0) result = -result - 1;

          // array [0, 1, 2, 3, 4, 5]
          // search 8
          // return -6 -1 = -7
          // check if -(-7) -1  === 6 (array size)
          // if so, eleement not exsit return false
          if (result == list.size()) return false;
          minIndex  = list.get(result) + 1;
        }
        return true;
    }
}
