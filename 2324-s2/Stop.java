class Stop {
  private final int id;
  private Queue<Passenger> queue;

  public Stop(int id, int capacity) {
    this.id = id;
    this.queue = new Queue<>(capacity);
  }

  public Passenger removePassenger() {
    return queue.deq();
  }

  public boolean addPassenger(Passenger p) {
    return queue.enq(p);
  }

  public String toString() {
    return "COM" + this.id + " " + this.queue;
  }
}
