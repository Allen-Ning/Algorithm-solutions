class Solution {
  public String solveEquation(String equation) {
    if (equation == null || equation.length() == 0) return "No solution";

    int cofX = 0;
    int value = 0;
    int sign = 1;
    int num = 0;
    // trick -> for left part normal = 1, for right part normal = -1
    int normal = 1;
    for (int i = 0; i < equation.length(); i++) {
      char c = equation.charAt(i);
      if (c == '+') {
        if (i - 1 >= 0 && equation.charAt(i - 1) != 'x') value += normal* sign * num;
        sign = 1;
        num = 0;
      } else if (c == '-') {
        if (i - 1 >= 0 && equation.charAt(i - 1) != 'x') value += normal* sign * num;
        sign = -1;
        num = 0;
      } else if (c == '=') {
        if (i - 1 >= 0 && equation.charAt(i - 1) != 'x') value += normal* sign * num;
        normal = -1;
        sign = 1;
        num = 0;
      } else if (c == 'x') {
          if (num == 0 && i - 1 >= 0 && (equation.charAt(i - 1) < '0' || equation.charAt(i - 1) > '9')) num = 1;
          if (num == 0 && i == 0) num = 1;
          cofX += normal* sign * num;
          num = 0;
      } else {
        num = num * 10 + (c - '0');
      }
    }

    // trick -> we need to add the num to value at teh end
    if (num > 0) value += normal* sign * num;
    if (cofX == 0 && value == 0) return "Infinite solutions";
    if (cofX == 0) return "No solution";
    return "x="+ (-value / cofX);
  }
}
