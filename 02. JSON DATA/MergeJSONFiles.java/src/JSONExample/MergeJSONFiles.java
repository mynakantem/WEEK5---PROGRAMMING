package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> json1 = mapper.readValue(new File("file1.json"), Map.class);
            Map<String, Object> json2 = mapper.readValue(new File("file2.json"), Map.class);

            json1.putAll(json2);  

            System.out.println("Merged JSON: " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1));
        } catch (Exception e) {
            e.printStackTrace();
        }
//    }
}
