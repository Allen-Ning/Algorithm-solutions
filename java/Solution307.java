// 0  1    2    3  4  5  6  7
//   4,7  4,5  6,7 1  2  3  4
class NumArray {
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length * 2];
        buildSegmentTree(nums);
    }

    public void update(int i, int val) {
        nums[i] = val;
        int index = (i + nums.length);
        tree[index] = val;

        int parentIndex = index;
        // parentIndex * 2 = index
        // parentIndex * 2 + 1 = index
        while (parentIndex > 1) {
            // left child
            if (index % 2 == 0) {
                parentIndex = index / 2;
                tree[parentIndex] = tree[index] + tree[index + 1];
                index = parentIndex;
            // right child
            } else {
                parentIndex = (index - 1) / 2;
                tree[parentIndex] = tree[index] + tree[index - 1];
                index = parentIndex;
            }
        }
    }
    
    // trick -> this very tricky
    // looking for start from left child, otherwise add the value
    // looking for end from right child, otherwise add the value
    // if start == end, will add it in anyway, and then exit loop
    public int sumRange(int i, int j) {
        // 0   1     2       3   4     5   6   7   8   9
        //     24    10     14   10    1,  9,  5,  7 , 3
        //    89567 8,9,5   6,7  8,9   5
        // 56789
        // [2, 4]
        // [7, 9]
        int start = i + nums.length;
        int end = j + nums.length;
        int sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }

            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }

        return sum;
    }

    private void buildSegmentTree(int[] nums) {
        for (int i = nums.length; i < tree.length; i++) {
            tree[i] = nums[i - nums.length];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
