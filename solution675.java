class Solution {
  public int cutOffTree(List<List<Integer>> forest) {
    if (forest == null || forest.size() == 0) return 0;

    Queue<Element> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
    for (int i = 0; i < forest.size(); i++) {
      for (int j = 0; j < forest.get(0).size(); j++) {
        if (forest.get(i).get(j) > 1) queue.offer(new Element(i, j, forest.get(i).get(j)));
      }
    }

    int totalStep = 0;
    // trick -> this question asks to always start from (0,0).
    //          But (0,0) might not always be the smallest element.
    //          If (0, 0) is the smallest element then will return step 0 and set the (0, 0) to value 1
    //          Else (0, 0) is not the smallest element then will return step from (0, 0) to the smallest element and
    //          set the the samellestt element value to 1
    Element e1 = new Element(0, 0, 1);
    while(!queue.isEmpty()) {
      Element e2 = queue.poll();
      int step = findStep(forest, e1, e2);
      if (step == -1) return -1;

      totalStep += step;
      e1 = e2;
    }
    return totalStep;
  }

  private int findStep(List<List<Integer>> forest, Element e1, Element e2) {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    Queue<Element> queue = new LinkedList();
    boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
    visited[e1.x][e1.y] = true;
    queue.offer(e1);

    int step = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Element e = queue.poll();
        if (e.x == e2.x && e.y == e2.y) return step;
        forest.get(e.x).set(e.y, 1);

        for (int[] dir : dirs) {
          int newX = e.x + dir[0];
          int newY = e.y+ dir[1];

          if (newX >= 0 &&
              newX < forest.size() &&
              newY >= 0 &&
              newY < forest.get(0).size() &&
              !visited[newX][newY] &&
              forest.get(newX).get(newY) > 0) {
            Element newE = new Element(newX, newY, forest.get(newX).get(newY));
            queue.offer(newE);
            // trick -> add the visietd here to make the code run faster due to avoiding duplication
            visited[newX][newY] = true;
          }
        }
      }
      step++;
    }
    return -1;
  }

  class Element {
    int x;
    int y;
    int height;

    public Element(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
  }
}
