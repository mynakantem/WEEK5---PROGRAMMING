package JSONExample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSONStructure {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\",\"age\":28}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(json);
            if (root.has("name") && root.has("age")) {
                System.out.println("Valid JSON Structure ✅");
            } else {
                System.out.println("Missing required fields ❌");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON format ❌");
        }
    }
}

