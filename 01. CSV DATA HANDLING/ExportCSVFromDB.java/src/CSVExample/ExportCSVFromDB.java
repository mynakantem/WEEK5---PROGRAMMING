package CSVExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCSVFromDB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/?user=root";
        String dbUser = "root";            
        String dbPassword = "Jayacse.sql"; 

        String csvFile = "employees_report.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String query = "SELECT id, name, department, salary FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dept = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                String line = id + "," + name + "," + dept + "," + salary;
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            resultSet.close();
            statement.close();

            System.out.println("✅ CSV Report Generated: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}