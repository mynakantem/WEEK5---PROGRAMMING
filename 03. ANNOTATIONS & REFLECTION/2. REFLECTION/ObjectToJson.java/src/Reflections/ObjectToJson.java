package Reflections;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ObjectToJson {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            try {

                fields[i].setAccessible(true);
                
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);
                
                json.append("\"").append(fieldName).append("\": \"").append(fieldValue).append("\"");
                
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        
        return json.toString();
    }

    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        
        String json = toJson(person);
        
        System.out.println(json);
    }
}
