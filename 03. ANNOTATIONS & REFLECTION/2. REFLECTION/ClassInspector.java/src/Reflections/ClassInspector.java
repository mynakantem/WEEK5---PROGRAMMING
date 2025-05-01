package Reflections;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInspector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fully qualified class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("\n--- Methods ---");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println(method);
            }

            System.out.println("\n--- Fields ---");
            for (Field field : cls.getDeclaredFields()) {
                System.out.println(field);
            }

            System.out.println("\n--- Constructors ---");
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
