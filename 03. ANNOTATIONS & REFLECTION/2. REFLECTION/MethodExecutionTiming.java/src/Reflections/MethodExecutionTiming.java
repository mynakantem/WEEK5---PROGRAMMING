package Reflections;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
public @interface LogExecutionTime {
}

class SampleClass {

    @LogExecutionTime
    public void performTask1() {
        try {
            Thread.sleep(2000);  
            System.out.println("Task 1 completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void performTask2() {
        try {
            Thread.sleep(1000);  
            System.out.println("Task 2 completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void performOtherTask() {
        System.out.println("Other task (not timed).");
    }
}

class ExecutionTimer {

    public static void measureExecutionTime(Object obj) {
     
        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                 
                    long startTime = System.nanoTime();

                    method.setAccessible(true);

                    method.invoke(obj);

                    long endTime = System.nanoTime();

                    long duration = (endTime - startTime) / 1000000;  
                    System.out.println("Execution time of " + method.getName() + ": " + duration + " ms");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) {
        SampleClass sample = new SampleClass();

        ExecutionTimer.measureExecutionTime(sample);
    }
}

