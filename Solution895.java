class FreqStack {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> stacks;
    int maxFrequency;
    public FreqStack() {
      this.freq = new HashMap();
      this.stacks = new HashMap();
      this.maxFrequency = 0;
    }

    public void push(int x) {
      int frequency = freq.getOrDefault(x, 0) + 1;
      freq.put(x, frequency);
      maxFrequency = Math.max(maxFrequency, frequency);
      Stack<Integer> stack = stacks.getOrDefault(frequency, new Stack<Integer>());
      stack.push(x);
      stacks.put(frequency, stack);
    }

    public int pop() {  
      Stack<Integer> stack = stacks.getOrDefault(this.maxFrequency, new Stack<Integer>());
      int returnedValue = stack.pop();
      freq.put(returnedValue, this.maxFrequency - 1);
      if (stack.isEmpty()) maxFrequency -= 1; 
      return returnedValue;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
