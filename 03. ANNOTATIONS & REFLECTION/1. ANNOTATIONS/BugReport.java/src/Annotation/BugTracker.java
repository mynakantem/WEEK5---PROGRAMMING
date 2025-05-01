package Annotation;

public class BugTracker {

    @BugReport(description = "NullPointerException when input is null")
    @BugReport(description = "ArrayIndexOutOfBounds when index > size")
    public void processInput() {
        System.out.println("Processing input...");
    }
}
