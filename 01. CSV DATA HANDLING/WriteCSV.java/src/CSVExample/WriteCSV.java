package CSVExample;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("ID,Name,Department,Salary\n");

            writer.append("1,John,HR,45000\n");
            writer.append("2,Sara,Marketing,52000\n");
            writer.append("3,David,Engineering,75000\n");
            writer.append("4,Linda,Finance,60000\n");
            writer.append("5,Tom,IT,68000\n");

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing CSV file.");
            e.printStackTrace();
        }
    }
}
