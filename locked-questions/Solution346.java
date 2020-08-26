public class MovingAverage {
    LinkedList<Integer> list;
    int size;
    double total;

    /*
    * @param size: An integer
    */
    public MovingAverage(int size) {
        this.size = size;
        this.list = new LinkedList<Integer>();
        this.total = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        if (list.size() >= size) total -= list.removeFirst();
        list.addLast(val);
        total += val;
        return total / list.size(); 
    }
}