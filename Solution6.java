class Solution {
    public String convert(String s, int numRows) {
      StringBuilder[] sb = new StringBuilder[numRows];
      for (int i = 0; i < numRows; i++) {
        sb[i] = new StringBuilder("");
      }
      
      char[] characters = s.toCharArray();
      int i = 0;
      while(i < characters.length) {
        for (int j = 0; j < numRows && i < characters.length; j++) {
          sb[j].append(characters[i]);
          i++;
        }
        for (int j = numRows - 2; j > 0 && i < characters.length; j--) {
          sb[j].append(characters[i]);
          i++;
        }
      }

      String result = "";
      for (int index = 0; index < numRows; index++) {
        result += sb[index].toString();
      }
      return result;
    }
}
