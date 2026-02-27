import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TaskList {
  private Array<Task> array;

  private static final int TODO = 0;
  private static final int DEADLINE = 1;
  private static final int ASSIGNABLE = 2;

  public TaskList() {
    this(new Scanner(System.in));
  }

  public TaskList(String filename) throws FileNotFoundException {
    this(new Scanner(new File(filename)));
  }

  private TaskList(Scanner sc) {
    try {
      loadTasks(sc);
    } catch (WrongTaskTypeException e) {
      System.out.println(e.getMessage());
    } finally {
      sc.close();
    }
  }

  private void loadTasks(Scanner sc) throws WrongTaskTypeException {
    int numOfTasks = Integer.parseInt(sc.nextLine().trim());
    array = new Array<Task>(numOfTasks);
    int i = 0;
    while (sc.hasNext()) {
      String text = sc.nextLine().trim();
      String[] arguments = text.split(",");
      array.set(i, createTask(arguments));
      i = i + 1;
    }
  }

  private Task createTask(String[] args) throws WrongTaskTypeException { 
    String description = args[1];
    int type = Integer.parseInt(args[0]);
    Task t;
    if (type == TaskList.TODO) {
      t = new AnytimeTask(description);

    } else if (type == TaskList.DEADLINE) {
      int dueInDays = Integer.parseInt(args[2]);
      t = new DeadlineTask(description, dueInDays);

    } else if (type == TaskList.ASSIGNABLE) {
      int dueInDays = Integer.parseInt(args[2]);
      String assignee = args[3];
      t = new AssignableTask(description, dueInDays, assignee);

    } else {
      throw new WrongTaskTypeException("Invalid task type in input: " + type);
    }
    return t;
  }

  @Override
  public String toString() {
    String s = "";
    int i;
    for (i = 0; i < array.length(); i++) {
      s = s + "\n" + array.get(i);
    }
    return s;
  }

  public void printDueToday() {
    for (int i = 0; i < array.length(); i++) {
      Task task = array.get(i);
      if (task.isDueToday()) {
        System.out.println(i + " " + task.toPrettyString());
      }
    }
  }

  public int getRewardPoints() {
    int sum = 0;
    for (int i = 0; i < array.length(); i++) {
      Task task = array.get(i);
      sum += task.getRewardPoints();
    }
    return sum;
  }

  public void printTaskDescriptions() {
    for (int i = 0; i < array.length(); i++) {
      Task task = array.get(i);
      System.out.println(i + " " + task);
    }
  }

  public void printTaskDetails() {
    for (int i = 0; i < array.length(); i++) {
      Task task = array.get(i);
      System.out.println(i + " " + task.toPrettyString());
    }
  }

  public void remindAll() {
    for (int i = 0; i < array.length(); i++) {
      Task task = array.get(i);
      if (!task.isCompleted()) {
        task.remind();
      }
    }
  }

  public void completeTask(int index) {
    array.get(index).complete();
  }
}
