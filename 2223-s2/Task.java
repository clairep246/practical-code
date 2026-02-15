abstract class Task {
   
    private String description;
    private boolean isCompleted = false;

    public Task(String description) {
        this.description = description;
    }

    public void complete() { 
       this.isCompleted = true;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public abstract boolean isDueToday();
    public abstract int getRewardPoints();
    public abstract void remind();

    public String toPrettyString() {
      if (this.isCompleted) {
        return "[X] " + this;
      } else {
        return "[ ] " + this;
      }
    }

    @Override
    public String toString() {
        return this.description;
    }
}
