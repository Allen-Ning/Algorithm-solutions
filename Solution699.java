class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> results = new ArrayList();
        SegmentTree tree = new SegmentTree(0, 100_000_000, 0);

        int maxHeight = 0;
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            int start = position[0];
            int end = position[0] + position[1];

            int baseHeight = tree.query(start, end);
            int height = baseHeight + position[1];

            tree.build(start, end, height);
            if (tree.status > maxHeight) maxHeight = tree.status;
            results.add(maxHeight);
        }
        return results;
    }

    class SegmentTree {
        // trick -> the mininium segment is [start, end] (end = start + 1) such as [3, 4], [4, 5]
        int start, end;
        int status;
        SegmentTree leftTree;
        SegmentTree rightTree;

        public SegmentTree(int start, int end, int status) {
            this.start = start;
            this.end = end;
            this.status = status;
        }

        private int getMid() {
            return this.start + (this.end - this.start) / 2;
        }

        public void build(int left, int right, int value) {
            // left...................................right
            //       this.start............this.end
            if (left <= this.start && this.end <= right) {
                this.status = value;
                this.leftTree = null;
                this.rightTree = null;
                return;
            }

            //  left....right
            //                this.start...............this.end
            //
            //                                     left....right
            //  this.start...............this.end
            if (right <= this.start || left >= this.end) return;

            //  left...............right
            //        this.start.........mid......this.end

            //                       left..................right
            //        this.start.........mid......this.end
            int mid = getMid();
            if (this.leftTree == null) this.leftTree = new SegmentTree(this.start, mid, status);
            this.leftTree.build(left, right, value);

            if (this.rightTree == null) this.rightTree = new SegmentTree(mid, this.end, status);
            this.rightTree.build(left, right, value);

            this.status = Math.max(value, this.status);
        }

        public int query(int left, int right) {
            // left.....................................right
            //       this.start............this.end
            if (left < this.start && this.end < right) {
                return this.status;
            }

            //  left....right
            //                this.start...............this.end
            //
            //                                     left....right
            //  this.start...............this.end
            if (right <= this.start || left >= this.end) return 0;

            // trick -> this indicates the segement line is flat
            if (this.leftTree == null || this.rightTree == null) {
                return status;
            }

            //      left.....................right
            //        this.start.........mid......this.end

            //                       left..................right
            //        this.start.........mid......this.end
            int leftMax = this.leftTree.query(left, right);
            int rightMax = this.rightTree.query(left, right);
            return Math.max(leftMax, rightMax);
        }
    }
}