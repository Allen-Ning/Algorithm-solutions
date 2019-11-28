class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int[] parents = new int[edges.length * 2];
    for (int[] edge : edges) {
      if (parents[edge[0]] == 0) parents[edge[0]] = edge[0];
      if (parents[edge[1]] == 0) parents[edge[1]] = edge[1];
    }

    for (int[] edge : edges) {
      int parent1 = find(parents, edge[0]);
      int parent2 = find(parents, edge[1]);
      if (parent1 == parent2) return edge;
      union(parents, parent1, parent2);
    }
    return null;
  }

  int find(int[] parents, int child) {
    if (child != parents[child]) {
      int parent = parents[child];
      child = find(parents, parent);
    }
    return child;
  }

  void union(int[] parents, int parent1, int parent2) {
    parents[parent1] = parent2;
  }
}
