package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;

public class DbToJsonReport {
    public static void main(String[] args) {
    	String jdbcURL = "jdbc:mysql://localhost:3306/?user=root";
    	String dbUser = "root";
    	String dbPassword = "Jayacse.sql";

        String query = "SELECT id, name, age, email FROM users";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)
        ) {
            List<Map<String, Object>> records = new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                records.add(row);
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonReport = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);
            System.out.println("JSON Report:\n" + jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
