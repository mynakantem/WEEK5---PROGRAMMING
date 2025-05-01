package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJSONArray {
    public static void main(String[] args) throws Exception {
        List<Student> students = Arrays.asList(
            new Student("Anil", 22),
            new Student("Sunita", 23),
            new Student("Ravi", 21)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        System.out.println("JSON Array:\n" + jsonArray);
    }
}
