package Reflections;

import java.lang.reflect.Field;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();  

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey()); 
                field.setAccessible(true); 
                field.set(obj, entry.getValue());  
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found: " + entry.getKey());
            }
        }

        return obj;
    }

    public static void main(String[] args) {
        try {
            Map<String, Object> properties = Map.of(
                "name", "John Doe",
                "age", 30
            );

            Person person = toObject(Person.class, properties);

            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
