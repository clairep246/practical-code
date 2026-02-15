public class Passenger {
  private static int next = 0;
  private final int id;
  private int destination;

  public Passenger(int destination) {
    this.id = Passenger.next;
    this.destination = destination;
    Passenger.next = Passenger.next + 1;
  }

  public int getDestination() {
    return this.destination;
  }

  public boolean hasReachedDestination(int i) {
    return this.destination == i;
  }

  /*
     public int getDestination() {
     return this.destination;
     }
     */

  @Override
  public String toString() {
    return "P" + this.id + "->COM" + this.destination;
  }
}
