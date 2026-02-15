class DeadlineTask extends Task {
  private int dueInDays;
  private int points;

  public DeadlineTask(String description, int dueInDays) {
    super(description);
    this.dueInDays = dueInDays;
  }

  @Override
  public void complete() {
    super.complete();
    this.points += this.dueInDays;
  }

  @Override
  public int getRewardPoints() {
    return this.points;
  }

  @Override
  public boolean isDueToday() {
    return dueInDays == 0;
  }

  @Override
  public void remind() {
    System.out.println("The task \"" + this + "\" is due in " + dueInDays + " days");
  }

  @Override
  public String toPrettyString() {
    return super.toPrettyString() + " | Due in " + dueInDays + " days";
  }
}
