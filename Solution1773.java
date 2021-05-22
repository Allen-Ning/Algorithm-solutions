class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int itemIndex = getItemIndex(ruleKey);

        int result = 0;
        for (List<String> item : items) {
            String itemValue = item.get(itemIndex);
            if (itemValue.equals(ruleValue)) result++;
        }
        return result;
    }

    private int getItemIndex(String ruleKey) {
        int index = -1;
        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else if (ruleKey.equals("name")) {
            index = 2;
        }
        return index;
    }
}