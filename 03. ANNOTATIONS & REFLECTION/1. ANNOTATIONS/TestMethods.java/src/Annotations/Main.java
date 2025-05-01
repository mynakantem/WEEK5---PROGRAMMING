package Annotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        TestMethods obj = new TestMethods();
        Method[] methods = TestMethods.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println("⏱ " + method.getName() + " executed in " + (end - start) / 1_000_000.0 + " ms");
            }
        }

        obj.notLoggedTask();
    }
}
