package Annotations;

public class Service {

    @ImportantMethod
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void helperMethod() {
        System.out.println("This method is not marked as important.");
    }
}
