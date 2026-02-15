public class ArrivalEvent extends Event {
  private Passenger passenger;
  private Stop stop;

  public ArrivalEvent(double time, Passenger p, Stop stop) {
    super(time);
    this.passenger = p;
    this.stop = stop;
  }

  @Override
  public Event[] simulate() {
    boolean success = this.stop.addPassenger(this.passenger);
    if (!success) {
      return new Event[] { 
        new DepartureEvent(this.getTime(), this.passenger)
      };
    }
    return new Event[] { };
  }

  @Override
  public String toString() {
    return super.toString() + " " + this.passenger + " arrives at " + this.stop;
  }
}
