class TicketQueue extends Queue<Ticket> implements Comparable<TicketQueue> {
  private final int priority;

  public TicketQueue(int priority, int size) {
    super(size);
    this.priority = priority;
  }

  @Override
  public boolean enq(Ticket t) {
    if (t.getPriority() == this.priority) {
      return super.enq(t);
    }
    return false;
  }

  @Override
  public int compareTo(TicketQueue q) {
    if (q == null || q.isEmpty()) {
      return 1;
    }

    if (this.isEmpty()) {
      return -1;
    }

    if (this.priority < q.priority) {
      // Q has higher priority
      return -1;
    } else if (this.priority == q.priority) {
      // both queues are equally important
      if (this.length() <= q.length()) {
        return -1;
      }
    } 
    return 1;
  }

  @Override
  public String toString() {
    return "Q" + this.priority + " " + super.toString();
  }
}
