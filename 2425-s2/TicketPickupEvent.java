class TicketPickupEvent extends Event {
  private RTSystem rtsys;
  private Ticket ticket;
  private Admin admin;

  public TicketPickupEvent(double time, RTSystem rtsys, Ticket ticket, Admin admin) {
    super(time);
    this.rtsys = rtsys;
    this.ticket = ticket;
    this.admin = admin;
  }

  @Override
  public Event[] simulate() {
    double nextTime = this.getTime() + this.ticket.getProcessingTime();
    return new Event[] {new TicketProcessedEvent(nextTime, rtsys, ticket, admin)};
  }

  @Override
  public String toString() {
    return super.toString() + " " + this.admin + " picked up " + this.ticket + " " + this.rtsys;
  }
}
