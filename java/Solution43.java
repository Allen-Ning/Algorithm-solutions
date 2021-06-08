class Solution {
    public String multiply(String num1, String num2) {
      char[] num1Array = num1.toCharArray();
      char[] num2Array = num2.toCharArray();

      int[] result = new int[num1.length() + num2.length()];
      for (int i = num1Array.length - 1; i >= 0; i--) {
        for (int j = num2Array.length - 1; j >= 0; j--) {
          int sum = (num2Array[j] - '0') * (num1Array[i] - '0') + result[i + j + 1];
          result[i + j + 1] = sum  % 10;
          result[i + j] +=  sum / 10;
        }
      }

      String finalResult = "";
      boolean leadingZero = true;
      for (int i = 0; i < result.length; i++) {
        if (leadingZero && result[i] == 0) {
          continue;
        } else {
          leadingZero = false;
          finalResult += result[i];
        
        }
      }

      return finalResult.equals("") ? "0" : finalResult;
    }
}


