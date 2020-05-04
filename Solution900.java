class RLEIterator {
    int[] A;
    int index;
    public RLEIterator(int[] A) {
        this.A = A;
        this.index = 0;
    }

    public int next(int n) {
        while (n > 0 && index < A.length) {
            int counter = A[index];
            if (n <= counter) {
                A[index] = counter - n;
                return A[index + 1];
            } else {
                n -= counter;
            }
            index += 2;
        }
        return -1;
    }
}
