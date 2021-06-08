class Solution {
    //  0  1  2  3
    //  1  2  1
    //  1  1  2  1
    //  1  3  3  1
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() -1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        
        return list;  
      }
}
