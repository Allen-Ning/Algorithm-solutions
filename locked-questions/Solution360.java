public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // Write your code here
        // ax2 + bx + c
        // 2ax + b = 0
        // 2ax = -b
        // x = - b/2a
        double value = -1 * (double) b / (2 * (double) a);
        int[] result = new int[nums.length];
        int l = -1;
        int h = -1;

        if (a == 0) {
            if (b >= 0) {
                h = 0;
                l = -1;
            } else {
                h = nums.length;
                l = nums.length - 1;
            }
        } else {
            int index = binarySearch(nums, value);
            if (value == nums[index]) {
                l = index;
                h = index + 1;
            } else {
                l = index - 1;
                h = index;
            }
        }

        int counter = 0;
        while (l >= 0 && h < nums.length) {
            int resultL = cal(a, b, c, nums[l]);
            int resultH = cal(a, b, c, nums[h]);
            if (a > 0) {
                if (resultL < resultH) {
                    result[counter++] = resultL;
                    l--;
                } else {
                    result[counter++] = resultH;
                    h++;
                } 
            } else {
                if (resultL > resultH) {
                    result[counter++] = resultL;
                    l--;
                } else {
                    result[counter++] = resultH;
                    h++;
                } 
            }
        }
        while (l >= 0) result[counter++] = cal(a, b, c, nums[l--]);
        while (h < nums.length) result[counter++] = cal(a, b, c, nums[h++]);

        if (a < 0) reverse(result);
        return result;
    }

    private int binarySearch(int[] nums, double value) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= value) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    private void reverse(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l++;
            h--;
        }
    }

    private int cal(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}