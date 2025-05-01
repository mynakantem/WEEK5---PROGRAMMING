package JSONExample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class FilterAgeAbove25 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("Students.json")); 

        for (JsonNode student : root) {
            if (student.get("age").asInt() > 25) {
                System.out.println("Student > 25:\n" + student.toPrettyString());
            }
        }
    }
}
