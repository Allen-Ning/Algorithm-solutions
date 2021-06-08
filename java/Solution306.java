class Solution {
  public boolean isAdditiveNumber(String num) {
    for (int i = 1; i <= num.length() / 2; i++) {
      for (int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
        if (isValid(num, i, j)) return true;
      }
    }
    return false;
  }

  private boolean isValid(String num, int i, int j) {
    if (num.charAt(0) == '0' && i > 1) return false;
    if (num.charAt(i) == '0' && j > 1) return false;

    Long first = Long.parseLong(num.substring(0, i));
    Long second = Long.parseLong(num.substring(i, i + j));
    String sumStr = "";
    for (int index = i + j; index < num.length(); index += sumStr.length()) {
      long sum = first + second;
      sumStr = Long.toString(first + second);
      if (!num.startsWith(sumStr, index)) return false;
      first = second;
      second = sum;
    }
    return true;
  }
}
