package Annotations;

public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeReport() {
        System.out.println("Completing the report task...");
    }
}
