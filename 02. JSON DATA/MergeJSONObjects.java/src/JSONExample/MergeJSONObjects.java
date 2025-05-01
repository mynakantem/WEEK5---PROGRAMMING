package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJSONObjects {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Asha");
        json1.put("age", 25);

        ObjectNode json2 = mapper.createObjectNode();
        json2.put("email", "asha@example.com");
        json2.put("phone", "9876543210");

        json1.setAll(json2);

        System.out.println("Merged JSON:\n" + json1.toPrettyString());
    }
}
