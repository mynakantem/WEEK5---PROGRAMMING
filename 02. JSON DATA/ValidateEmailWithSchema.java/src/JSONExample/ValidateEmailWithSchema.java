package JSONExample;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;

public class ValidateEmailWithSchema {
    public static void main(String[] args) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream("Schema.json")));
            JSONObject jsonData = new JSONObject(new JSONTokener(new FileInputStream("User.json")));

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonData); 

            System.out.println("Valid JSON with valid email!");
        } catch (Exception e) {
            System.out.println("Invalid JSON or Email: " + e.getMessage());
        }
    }
}
