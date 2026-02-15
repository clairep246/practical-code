class Ticket {
  private final int id;
  private int priority;
  private double processingTime;

  private static int nextId = 100;

  public Ticket(int priority, double processingTime) {
    this.id = Ticket.nextId;
    this.priority = priority;
    this.processingTime = processingTime;
    Ticket.nextId += 1;
  }

  public double getProcessingTime() {
    return this.processingTime;
  }

  public int getPriority() {
    return this.priority;
  }

  @Override
  public String toString() {
    return "T" + this.id;
  }
}
