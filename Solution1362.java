class Solution {
    public int[] closestDivisors(int num) {
        int value = (int) Math.sqrt(num + 2);
        for (int i = value; i >= 0; i--) {
            if ((num + 1) % i == 0) {
                return new int[] {i, (num + 1) / i};
            } else if ((num + 2) % i == 0) {
                return new int[] {i, (num + 2) / i};
            }
        }
        return null;
    }
}