package JSONExample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ExtractFieldsFromJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("student.json")); 

        String name = root.path("name").asText();
        String email = root.path("email").asText();

        System.out.println("Extracted Fields:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
