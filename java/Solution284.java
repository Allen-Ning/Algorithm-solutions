// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
  private Iterator<Integer> it;
  private Integer next;
  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.it = iterator;
    if (it.hasNext()) { next = it.next(); }
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    int currentNext = this.next;
    if (it.hasNext()) { 
      this.next = it.next(); 
    } else {
      this.next = null;
    }
    return currentNext;
  }

  @Override
  public boolean hasNext() {
    return next == null ? false : true;
  }
}
