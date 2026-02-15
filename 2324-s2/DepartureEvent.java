class DepartureEvent extends Event {
  Passenger p;

  public DepartureEvent(double time, Passenger p) {
    super(time);
    this.p = p;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString() + " " + p + " departs";
  }
}
