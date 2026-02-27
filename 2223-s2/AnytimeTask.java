public class AnytimeTask extends Task {
  public AnytimeTask(String description) {
    super(description);
  }

  @Override
  public boolean isDueToday() {
    return false;
  }

  @Override
  public int getRewardPoints() {
    return 0;
  }

  @Override 
  public void remind() {
    // do nothing
  }
}
