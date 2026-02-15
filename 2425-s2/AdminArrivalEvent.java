class AdminArrivalEvent extends Event {
  private Admin admin;
  private RTSystem rtsys;

  public AdminArrivalEvent(double time, RTSystem rtsys, Admin admin) {
    super(time);
    this.rtsys = rtsys;
    this.admin = admin;
  }

  @Override
  public Event[] simulate() {
    Ticket t = rtsys.nextTicket();
    if (t == null) {
      return new Event[] {};
    }
    return new Event[] {
      new TicketPickupEvent(this.getTime() + 0.2, rtsys, t, admin),
    };
  }

  @Override
  public String toString() {
    return super.toString() + " " + this.admin + " arrived " + this.rtsys;
  }
}
