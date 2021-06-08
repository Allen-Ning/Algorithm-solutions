class Solution {
    // trick -> find images in notes for visualized solution
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0; 
        int j = people.length - 1;
        int counter = 0;
        // trick -> very greedy way to solve this problem
        while (i <= j) {
            if (people[j] + people[i] <= limit) i++;
            j--;
            counter++;
        }
        return counter;
    }
}
