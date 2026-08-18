class Solution {
    public String largestNumber(int[] nums) {
        String[] results = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = String.valueOf(nums[i]);
        }
        // trick -> comparing the nums char by char will not work.
        //          e.g  3 vs 34 -> 334 < 343
        //               3 vs 30 -> 330 > 303
        Arrays.sort(results, (a, b) -> (b + a).compareTo(a + b));

        // trick -> This is to avoid corner case. If largest is "0", all nums are 0, avoid returning "000...""
        if (results[0].equals("0")) return results[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i]);
        }
        return sb.toString();
    }
}
