/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    // trick -> as for read4, we only need to provide a empty buffer.
    //          And then read4 will fill it up with 4 chars
    public int read(char[] buf, int n) {
        int counter = 0;

         char[] temp = new char[4];
         while (counter < n) {
            int value = read4(temp);

            if (value == 0) return counter;

            int length = Math.min(value, n - counter);
            for (int i = 0; i < length; i++) {
                buf[counter++] = temp[i];
            }
        }
        return counter;
    }
}