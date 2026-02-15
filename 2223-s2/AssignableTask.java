public class AssignableTask extends DeadlineTask {

    private String assignee;

    public AssignableTask(String taskText, int dueInDays, String assignee) {
        super(taskText, dueInDays);
        this.assignee = assignee;
    }

    @Override 
    public void remind() {
        System.out.println("Sending a reminder to complete \"" + this + "\" to " + assignee);
    }

    @Override
    public String toPrettyString() {
      return super.toPrettyString() + " | Assigned to " + assignee;
    }
}
