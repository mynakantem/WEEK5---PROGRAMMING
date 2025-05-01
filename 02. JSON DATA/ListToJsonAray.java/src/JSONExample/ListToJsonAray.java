package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonAray {
    public static void main(String[] args) {
        try {
            List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25)
            );

            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(people);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
