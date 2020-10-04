/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {

    char[] last4Read;
    // trick -> offset will not include the current index
    //          if lastOffset is 3, it means index 3 is the first index available to read
    int lastOffSet;
    int lastTotal;

    public int read(char[] buf, int n) {
        int currentIndex = 0;

        // trick -> read from the last round leftover
        if (last4Read != null && lastOffSet < lastTotal) {
            for (int i = lastOffSet; i < lastTotal; i++) {
                if (n == 0) {
                    lastOffSet = i;
                    return currentIndex;
                }
                buf[currentIndex++] = last4Read[i];
                n--;
            }
        }

        // trick -> read all from the last round and clean it up
        if (last4Read != null) {
            last4Read = null;
            lastOffSet = -1;
            lastTotal = -1;
        }

        char[] temp = new char[4];
        while (n > 0) {
            // trick -> read4 API will not read from the beginning, which means it will keep reading from the last stoped chars
            int num = read4(temp);
            // trick -> reach the last char of the given String (no more char)
            if (num == 0) return currentIndex;

            // trick -> we only need to read the char we can read here
            //          e.g. num = 4 (each read 4 chars), n = 5 (we need 5 more chars to be read)
            //               num = 3 (only 3 left chars), n = 2 (we need 2 more chars to be read)
            int count = Math.min(num, n);
            for (int i = 0; i < count; i++) buf[currentIndex++] = temp[i];

            // trick -> save last4Read for the next round to read
            if (n < num) {
                last4Read = temp;
                lastTotal =  num;
                lastOffSet = n;
            }
            n -= num;
        }

        return currentIndex;
    }
}