package Annotations;

public class TestMethods {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
    }

    public void notLoggedTask() {
        System.out.println("This method is not being timed.");
    }
}
