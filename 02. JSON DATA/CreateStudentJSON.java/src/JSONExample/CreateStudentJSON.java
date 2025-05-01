package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateStudentJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Rahul");
        student.put("age", 21);
        ArrayNode subjects = mapper.createArrayNode();
        subjects.add("Math").add("Science").add("English");
        student.set("subjects", subjects);

        System.out.println("Student JSON:\n" + student.toPrettyString());
    }
}
