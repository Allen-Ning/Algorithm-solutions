/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // trick -> n could be Integer.MAX_VALUE,which could introduce overflow
        long start = 0;
        long end = (long) n + 1;

        while (start + 1 != end) {
            long mid = start + (end - start) / 2;

            if (isBadVersion((int) mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return (int) end;
    }
}