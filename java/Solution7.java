class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // trick -> negative number % operation will return negative number
            //          e.g -201 % 10 = -1
            int reminder = x % 10;
            x /= 10;
            int newResult = result * 10 + reminder;
            // trick -> revere the operation and check if we can get the original result from the new result
            //          if overflow, we cannot get the original result from the new result
            //          if not overflow, we can get the original result from the new result
            if ((newResult - reminder) / 10 != result) return 0;    
            result = newResult;
        }
        return result;
    }
}