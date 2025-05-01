package Annotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Method[] methods = ProjectModule.class.getDeclaredMethods();

        System.out.println("📋 Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task: " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}
