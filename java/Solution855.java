class ExamRoom {
  int N;
  TreeSet<Integer> seats;

  public ExamRoom(int N) {
    this.seats = new TreeSet();
    this.N = N;
  }

  public int seat() {
    if (seats.size() == 0) {
      seats.add(0);
      return 0;
    } else if (seats.size() == 1) {
      int current = seats.first();
      if ((current - 0) >= (N - 1 - current)) {
        seats.add(0);
        return 0;
      } else {
        seats.add(N -1);
        return N - 1;
      }
    } else {
      int max = 0;
      int maxPrev = -1;
      int maxSeat = -1;
      int prev = -1;

      // trick -> pre-processing to handle first element not 0
      if (seats.size() > 0 && seats.first() > 0) {
          maxPrev = 0;
          maxSeat = 0;
          max = seats.first() - 1;
      }

      for (int seat : seats) {
        if ((seat - prev) / 2 > max) {
          max = (seat - prev) / 2;
          maxPrev = prev;
          maxSeat = seat;
        }
        prev = seat;
      }

      // trick -> post-processing to handle last element is not in seats   
      if (prev < N - 1 && (N - prev) / 2 > max) {
          seats.add(N -1);
          return N - 1;     
      }

      // trick -> handle all values between two seats including (pre-processing to handle first element not 0)
      if (max > 0) {
          seats.add(maxPrev + (maxSeat - maxPrev) / 2);
          return maxPrev + (maxSeat - maxPrev) / 2;
      } else {
          return -1;
      }
    }
  }

  public void leave(int p) {
    seats.remove(p);
  }
}
