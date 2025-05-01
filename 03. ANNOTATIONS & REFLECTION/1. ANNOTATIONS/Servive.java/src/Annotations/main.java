package Annotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() +
                                   ", Level: " + annotation.level());
            }
        }

        // Run the methods (optional)
        Service s = new Service();
        s.processData();
        s.generateReport();
        s.helperMethod();
    }
}
