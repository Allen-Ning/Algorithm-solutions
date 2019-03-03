class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    for (int i = 1; i < triangle.size(); i++) {
      for(int j = 0; j < triangle.get(i).size(); j++) {
        int value = 0;
        if (j == 0) {
          value = triangle.get(i - 1).get(j) + triangle.get(i).get(j); 
        } else if (j == triangle.get(i).size() - 1) {
          value =  triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j);
        } else {
          value = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)) + triangle.get(i).get(j);
        }
        triangle.get(i).set(j, value);
      }
    }
    
    int result = Interge.MAX_VALUE;
    for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
      result = Math.min(result, triangle.get(triangle.size() -1).get(i));
    }
    return result;
  }
}
