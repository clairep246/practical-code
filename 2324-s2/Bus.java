/*
 * @author Ashish Dandekar
 * @version CS2030S AY23/24 Sem 2
 * 
 * Bus class models an shuttle with a limited capacity.
 */
class Bus {
  private static int nextId = 0;
  private final int id;
  private final int capacity;
  private final int totalStops;
  private int currentOccupancy = 0;
  private int currentStop = 0;
  private Queue<Passenger>[] passengers;

  public Bus(int capacity, int totalStops) {
    this.id = Bus.nextId++;
    this.capacity = capacity;
    this.totalStops = totalStops;
    @SuppressWarnings("unchecked")
    Queue<Passenger>[] temp = (Queue<Passenger>[]) new Queue<?>[totalStops];
    for (int i = 0; i < totalStops; i += 1) {
      temp[i] = new Queue<Passenger>(capacity);
    }
    this.passengers = temp;
  }

  public int getCurrentStop() {
    return this.currentStop;
  }

  public boolean isFull() {
    return this.currentOccupancy >= this.capacity;
  }

  public Bus board(Passenger p) throws CannotBoardException {
    if (!this.isFull()) {
      this.passengers[p.getDestination()].enq(p);
      this.currentOccupancy += 1;
    } else {
      throw new CannotBoardException("Bus is full"); 
    }
    return this;
  }

  public Bus alight() {
    Queue<Passenger> q = this.passengers[this.currentStop];
    while (!q.isEmpty()) {
      q.deq();
      this.currentOccupancy -= 1;
    }
    return this;
  }

  public Queue<Passenger> getAlightingPassengers() {
    return this.passengers[this.currentStop];
  }

  public Bus move() {
    this.currentStop = (this.currentStop + 1) % this.totalStops;
    return this;
  }

  @Override
  public String toString() {
    String s = "B" + id + "@COM" + currentStop + " passengers: ";
    for (int i = 0; i < totalStops; i += 1) {
      s += this.passengers[i] + " ";
    }
    return s;
  }
}
