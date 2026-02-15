class TicketDroppedEvent extends Event {
  private Ticket ticket;
  private CongestionException exception;

  public TicketDroppedEvent(double time, CongestionException exception, Ticket ticket) {
    super(time);
    this.exception = exception;
    this.ticket = ticket;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString() + " " + this.ticket + " dropped: " + this.exception.getMessage();
  }
}
