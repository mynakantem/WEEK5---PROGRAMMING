package JSONExample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;

public class FilterUsersByAge {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> users = mapper.readValue(
                new File("users.json"),
                new TypeReference<List<Map<String, Object>>>() {}
            );

            for (Map<String, Object> user : users) {
                int age = (int) user.get("age");
                if (age > 25) {
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
