class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        String key = "";
        List<List<String>> results = new ArrayList();
        for (int i = 0; i < searchWord.length(); i++) {
            key += searchWord.charAt(i);
            int startIndex = lowboundSearch(products, key);
            int endIndex = lowboundSearch(products, key + "~");
            List<String> result = new ArrayList();
            int start = startIndex;
            // trick -> end means the last avaible index
            //          there could be less than 3 available results -> we need endIndex - 1 to check the last available element
            int end = Math.min(startIndex + 2, endIndex - 1);
            for (int index = start; index <= end; index++) result.add(products[index]);
            results.add(result);
        }
        return results;
    }

    private int lowboundSearch(String[] products, String key) {
        int l = 0;
        int r = products.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (products[m].compareTo(key) >= 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
