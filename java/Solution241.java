class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input);
    }

    private List<Integer> helper(String input) {
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                //  "2*3-4*5"
                List<Integer> list1 = helper(input.substring(0, i));
                List<Integer> list2 = helper(input.substring(i+1));

                for (int num1: list1) {
                    for (int num2: list2) {
                        if (input.charAt(i) == '+') {
                            result.add(num1 + num2);
                        } else if (input.charAt(i) == '-') {
                            result.add(num1 - num2);
                        } else if (input.charAt(i) == '*') {
                            result.add(num1 * num2);
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(input));   
        }
        return result;
    }
}
