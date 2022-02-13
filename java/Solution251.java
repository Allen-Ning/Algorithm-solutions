class Vector2D {
    int[][] vecs;
    int vecsSize;
    int index;
    int subIndex;

    public Vector2D(int[][] vecs) {
        this.vecs = vecs;
        this.vecsSize = vecs.length;
        this.index = 0;
        this.subIndex = 0;
    }

    public int next() {
        if (!hasNext()) return -1;

        int result = this.vecs[this.index][this.subIndex];
        this.subIndex++;
        return result;
    }

    public boolean hasNext() {
        // trick -> very neat implementation to avoid lots of guard early return code
        while (this.index < vecsSize && this.subIndex == this.vecs[index].length) {
            this.index++;
            this.subIndex = 0;
        }

        return this.index < vecsSize;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */