class Solution {
  public String reverseVowels(String s) {
    if (s.length() == 0) return s;
    char[] array = s.toCharArray();
    int start = 0;
    int end = array.length - 1;
    char temp = 0;
    while (start < end) {
      if (isVowel(array[start]) && isVowel(array[end])) {
        temp = array[start]; 
        array[start] = array[end];
        array[end] = temp;
        start++;
        end--;
      } else if (!isVowel(array[start])) {
        start++;
      } else if (!isVowel(array[end])) {
        end--;
      }
    }
    return new String(array);
  }

  private boolean isVowel(char c) {
    String vowels = "aeiouAEIOU";
    return vowels.contains(c+"");
  }
}
