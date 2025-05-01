package Reflections;

import java.lang.reflect.Field;

class Person {
    private int age = 25;  

    public String toString() {
        return "Person [age=" + age + "]";
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            System.out.println("Before Reflection: " + person);

            Field ageField = Person.class.getDeclaredField("age");

            ageField.setAccessible(true);

            ageField.setInt(person, 40);

            int updatedAge = ageField.getInt(person);
            System.out.println("Updated Age via Reflection: " + updatedAge);

            System.out.println("After Reflection: " + person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
