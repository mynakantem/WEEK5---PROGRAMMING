package Reflections;

public class DynamicObjectCreator {
    public static void main(String[] args) {
        try {
            // Create instance using .class reference (avoids ClassNotFoundException)
            Class<Student> clazz = Student.class;
            Student studentInstance = clazz.getDeclaredConstructor().newInstance();

            System.out.println("Dynamically created object: " + studentInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    String name = "Default";
    int rollNo = 1;

    public String toString() {
        return "Student{name='" + name + "', rollNo=" + rollNo + "}";
    }
}
