class UnionFind {
    int[] parents;

    // trick -> ranks is used to
    //              1. Rank is an estimate of the tree's height
    //              2. It's not the exact height, but a conservative upper bound
    //              3. The rank helps in deciding which tree to attach to which during union operations
    int[] ranks;

    public UnionFind(int n) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        ranks = new int[n];
    }

    public int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        // parents
        int p1 = find(x);
        int p2 = find(y);

        // If they are already in the same set, return
        if (p1 == p2) return;

        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            // trick -> if ranks are equal, arbitrarily choose one and increment its rank
            parents[p2] = p1;
            ranks[p1]++;
        }
    }
}