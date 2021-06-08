class Solution {
    public int[] processQueries(int[] queries, int m) {
        // trick -> 1 <= queries.length <= m means we need length of 2m + 1 to records all operation
        FenwickTree ft = new FenwickTree(2 * m);

        // [0, 1, 2, 3, m.....2m]
        // m = 5
        // [0, 5, 10]
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        int[] indexesByValue = new int[ft.data.length];
        for (int i = m + 1; i <= 2 * m; i++) {
            ft.update(i, 1);
            indexesByValue[i - m] = i;
        }

        // trick -> this remappedIndex will be filled one by one
        //          e.g. m = 5, remappedIndex will be 5 -> 4 -> 3 -> 2 -> 1
        int remappedIndex = m;
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = indexesByValue[queries[i]];
            int result = ft.query(index - 1);
            results[i] = result;
            ft.update(index, -1);
            ft.update(remappedIndex, 1);
            indexesByValue[queries[i]] = remappedIndex;
            remappedIndex--;
        }
        return results;
    }

    class FenwickTree {
        int[] data;

        public FenwickTree(int n) {
            this.data = new int[n + 1];
        }

        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += data[index];
                index -= index & (-index);
            }
            return sum;
        }

        public void update(int index, int delta) {
            while (index < data.length) {
                data[index] += delta;
                index += index & (-index);
            }
        }
    }
}
