class Solution {
  //  a / b = 2 => a = 2 b || a: 2  a -> b
  //  b / c = 3 => b = 3 c || b : 3  b -> c
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, String> parents = new HashMap();
    Map<String, Double> points = new HashMap();

    for (List<String> equation : equations) {
      parents.put(equation.get(0), equation.get(0));
      parents.put(equation.get(1), equation.get(1));
      points.put(equation.get(0), 1.0);
      points.put(equation.get(1), 1.0);
    }

    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String parent1 = find(parents, points, equation.get(0));
      String parent2 = find(parents, points, equation.get(1));
      // trick -> need to calcate the actual for parent1 and parent2
      // e.g
      //  [["a","b"],["e","f"],["b","e"]]
      //  [3.4,1.4,2.3]
      //  a / b = 3.4 || a = 3.4b
      //  e /f = 1.4  || e = 1.4f
      //  b / e = 2.3 || b = 2.3e
      union(parents, points, parent1, parent2, values[i] * points.get(equation.get(1)) / points.get(equation.get(0)));
    }

    double[] results = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      if (parents.get(query.get(0)) == null || parents.get(query.get(1)) == null) {
          results[i] = -1;
          continue;
      }

      String parent1 = find(parents, points, query.get(0));
      String parent2 = find(parents, points, query.get(1));

      results[i] = parent1 == parent2 ? points.get(query.get(0)) / points.get(query.get(1)) : -1;
    }
    return results;
  }

  private String find(Map<String, String> parents, Map<String, Double> points, String key) {
    String parentKey = parents.get(key);
    if (key != parentKey) {
        String newParentKey = find(parents, points, parentKey);
        // trick -> we need to recal distance value from current point to new parents
        points.put(key, points.get(key) * points.get(parentKey));
        parents.put(key, newParentKey);
    }
    return parents.get(key);
  }

  // [a, b], [b, a]
  private void union(Map<String, String> parents, Map<String, Double> points, String parent1, String parent2, double value) {
    if (value >= 1) {
        parents.put(parent1, parent2);
        points.put(parent1, value);
    } else {
        parents.put(parent2, parent1);
        points.put(parent2, 1 / value);
    }
  }
}
