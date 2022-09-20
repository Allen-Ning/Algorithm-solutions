class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        // trick -> preprocessing for consecutive increase count or decrease count
        int[] nonIncreasing = new int[security.length];
        int[] nonDecreasing = new int[security.length];

        for (int i = 1; i < security.length; i++) {
            int num = security[i];
            if (security[i - 1] >= security[i]) {
                nonIncreasing[i] = nonIncreasing[i - 1] + 1;
            } else {
                nonIncreasing[i] = 0;
            }
        }

        for (int i = security.length - 2; i >= 0; i--) {
            int num = security[i];
            if (security[i] <= security[i + 1]) {
                nonDecreasing[i] = nonDecreasing[i + 1] + 1; 
            } else {
                nonDecreasing[i] = 0;
            }
        }

        List<Integer> results = new ArrayList();
        for (int i = 0; i < nonIncreasing.length; i++) {
            if (nonIncreasing[i] >= time && nonDecreasing[i] >= time) {
                results.add(i);
            } 
        } 
        
        return results;  
    }
}