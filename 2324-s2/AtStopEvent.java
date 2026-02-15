public class AtStopEvent extends Event {
  private Bus bus;
  private Stop[] stops;

  public AtStopEvent(double time, Bus bus, Stop[] stops) {
    super(time);
    this.stops = stops;
    this.bus = bus;
  }

  @Override
  public Event[] simulate() {
    this.bus.alight();
    Stop s = this.stops[this.bus.getCurrentStop()];
    while (!bus.isFull()) {
      Passenger p = s.removePassenger();
      if (p == null) {
        break;
      }
      try {
        this.bus.board(p);
      } catch (CannotBoardException e) {
        System.out.println(e);
        break;
      }
    }
    bus.move();
    return new Event[] {
      new AtStopEvent(this.getTime() + BusSimulation.INTER_STOP_TRAVEL_TIME, 
          this.bus, this.stops)
    };
  }

  @Override
  public String toString() {
    Stop stop = this.stops[this.bus.getCurrentStop()];
    return super.toString() + " " + this.bus + " Stop: " + stop;
  }
}
