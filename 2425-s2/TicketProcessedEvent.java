class TicketProcessedEvent extends Event {
  private Admin admin;
  private Ticket ticket;
  private RTSystem rtsys;

  public TicketProcessedEvent(double time, RTSystem rtsys, Ticket ticket, Admin admin) {
    super(time);
    this.rtsys = rtsys;
    this.ticket = ticket;
    this.admin = admin;
  }

  @Override
  public Event[] simulate() {
    Ticket t = this.rtsys.nextTicket();
    if (t == null) {
      return new Event[] {};
    }
    return new Event[] {new TicketPickupEvent(this.getTime() + 0.2, rtsys, t, admin)};
  }

  @Override
  public String toString() {
    return super.toString() + " " + this.ticket + " processed " + this.rtsys;
  }
}
