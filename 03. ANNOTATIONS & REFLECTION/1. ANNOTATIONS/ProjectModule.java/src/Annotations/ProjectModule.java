package Annotations;

public class ProjectModule {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        // Not implemented yet
    }

    @Todo(task = "Add unit tests for payment", assignedTo = "Bob")
    public void paymentTests() {
        // Not implemented yet
    }

    public void completedFeature() {
        System.out.println("This feature is complete.");
    }
}
