class TicketSubmittedEvent extends Event {
  private RTSystem rtsys;
  private Ticket ticket;

  public TicketSubmittedEvent(double time, RTSystem rtsys, Ticket ticket) {
    super(time);
    this.rtsys = rtsys;
    this.ticket = ticket;
  }

  @Override
  public Event[] simulate() {
    try {
      this.rtsys.fileTicket(ticket);
    } catch (CongestionException e) {
      return new Event[] {new TicketDroppedEvent(this.getTime(), e, ticket)};
    }
    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString() + " " + this.ticket + " submitted " + this.rtsys;
  }
}
