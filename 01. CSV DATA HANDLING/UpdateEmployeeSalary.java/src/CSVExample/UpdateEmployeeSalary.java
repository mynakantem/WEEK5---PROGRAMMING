package CSVExample;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UpdateEmployeeSalary {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\mynak\\Desktop\\java projects\\week5\\01. CSV DATA HANDLING\\UpdateEmployeeSalary.java\\employees.csv";  
        String outputFilePath = "C:\\Users\\mynak\\Desktop\\java projects\\week5\\01. CSV DATA HANDLING\\UpdateEmployeeSalary.java\\updated_employees.csv";  

        try {
            CSVReader reader = new CSVReader(new FileReader(inputFilePath));
            List<String[]> records = reader.readAll();
            reader.close();

            for (String[] record : records) {
                if (record[2].equals("IT")) {  
                    double salary = Double.parseDouble(record[3]);
                    salary *= 1.10;  
                    record[3] = String.valueOf(salary); 
                }
            }

            CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath));
            writer.writeAll(records);
            writer.close();

            System.out.println("CSV file updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
