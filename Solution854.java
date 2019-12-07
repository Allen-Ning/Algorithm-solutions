class Solution {
  public int kSimilarity(String A, String B) {
    // BSF search
    if (A.equals(B)) return 0;

    int counter = 0;
    Queue<String> queue = new LinkedList();
    queue.offer(A);
    // trick -> this is for avoiding checked value
    HashSet<String> visited = new HashSet();
    visited.add(A);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int index = 0; index < size; index++) {
        String current = queue.poll();
        int i = 0;
        // trick -> skip all the same characters
        while (i < current.length() && current.charAt(i) == B.charAt(i)) {
            i++;
        }

        for (int j = i + 1; j < current.length(); j++) {
            // trick -> if the j character for current and B is correct, do not swop
            if (current.charAt(j) == B.charAt(j) || current.charAt(j) != B.charAt(i)) continue;
            String str = swap(current, i, j);
            if (str.equals(B)) return counter + 1;
            if (visited.add(str)) queue.offer(str);
        }

      }
      counter++;
    }
    return -1;
  }

  public String swap(String s, int i, int j){
        char[] ca=s.toCharArray();
        char temp=ca[i];
        ca[i]=ca[j];
        ca[j]=temp;
        return new String(ca);
  }
}
