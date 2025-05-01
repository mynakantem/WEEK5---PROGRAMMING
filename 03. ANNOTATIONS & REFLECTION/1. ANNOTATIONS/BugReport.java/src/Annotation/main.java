package Annotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Method method = BugTracker.class.getMethod("processInput");

            // Get all BugReport annotations
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

            for (BugReport report : bugReports) {
                System.out.println("Bug Description: " + report.description());
            }

            // Run the method
            new BugTracker().processInput();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

