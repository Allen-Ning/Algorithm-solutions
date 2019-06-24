// E.g.
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
// [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// Arrays.sort lambda

class Solution {
   public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1]: b[0] - a[0]));
        ArrayList<int[]> list = new ArrayList();
        for (int[] p : people) {
            list.add(p[1], p);   
        }
        return list.toArray(new int[people.length][2]);
    }
}
