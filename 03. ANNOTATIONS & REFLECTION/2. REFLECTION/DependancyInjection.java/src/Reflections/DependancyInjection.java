package Reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)  
public @interface Inject {
}

class DIContainer {

    public static void injectDependencies(Object object) {
    
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
           
                try {
                 
                    field.setAccessible(true);

                    Object dependency = field.getType().getDeclaredConstructor().newInstance();
                    field.set(object, dependency);  

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {

    @Inject
    private Engine engine;  

    public void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("Driving the car...");
        } else {
            System.out.println("Engine is not initialized!");
        }
    }
}

public class DependancyInjectionExample {

    public static void main(String[] args) {
        Car car = new Car();

        DIContainer.injectDependencies(car);

        car.drive();
    }
}
