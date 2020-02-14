class Solution {
 public List <String > removeComments(String[] source) {
  List < String > results = new ArrayList();

  if (source == null || source.length == 0) return results;

  boolean isCommented = false;

  StringBuilder sb = new StringBuilder();
  for (String line: source) {
   for (int i = 0; i < line.length(); i++) {
    char c = line.charAt(i);
    char nextC = 'e';
    if (i != line.length() - 1) nextC = line.charAt(i + 1);

    if (!isCommented && c == '/' && nextC == '*') {
     i += 1;
     isCommented = true;
    } else if (isCommented && c == '*' && nextC == '/') {
     i += 1;
     isCommented = false;
     continue;
    } else if (isCommented) {
     continue;
    } else if (c == '/' && nextC == '/') {
     break;
    } else {
     sb.append(c);
    }
   }
   if (!isCommented && sb.length() > 0) {
       results.add(sb.toString());
       sb = new StringBuilder();
   }
  }
  return results;
 }
}
