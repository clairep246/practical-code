class RTSystem {
  private Seq<TicketQueue> seq;

  public RTSystem(int numQueues, int queueSize) {
    this.seq = new Seq<>(numQueues);
    for (int i = 0; i < numQueues; i++) {
      TicketQueue tq = new TicketQueue(i, queueSize);
      this.seq.set(i, tq);
    }
  }

  public RTSystem fileTicket(Ticket t) throws CongestionException {
    TicketQueue q = this.seq.get(t.getPriority());
    if (q.isFull()) {
      throw new CongestionException(t.getPriority());
    }
    q.enq(t);
    return this;
  }

  public Ticket nextTicket() {
    TicketQueue temp = this.seq.max();
    if (temp.isEmpty()) {
      return null;
    }
    return temp.deq();
  }

  @Override
  public String toString() {
    return "RT: " + this.seq;
  }
}
