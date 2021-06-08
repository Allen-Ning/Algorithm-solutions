class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int number = countOne(data[i]);
            if (number > 4) return false;

            if (number > 1) {
                int checker = number - 1;
                while (checker > 0) {
                    if (data.length <= i+ checker || (data[i + checker] >> 6 & 3) != 2) {
                        return false;
                    }
                    checker--;
                }
                i += number - 1;
            } else if (number == 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private int countOne(int data) {
        int counter = 7;
        int result = 0;
        while((data >> counter & 1) == 1) {
            result++;
            counter--;
        }
        return result;
    }
}
