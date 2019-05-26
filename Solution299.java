class Solution {
  public String getHint(String secret, String guess) {
    int countA = 0;
    int countB = 0;
    int[] result = new int[10];
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        countA++;
      } else {
        if (result[secret.charAt(i) - '0'] < 0) countB++;
        if (result[guess.charAt(i) - '0'] > 0) countB++;
        result[secret.charAt(i) - '0'] += 1;
        result[guess.charAt(i) - '0'] -= 1;
      }    
    }
    return countA + "A" + countB + "B";
  }
}
