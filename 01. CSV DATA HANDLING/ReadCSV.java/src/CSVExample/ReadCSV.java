package CSVExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String line = "";
        String csvFile = "students.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: " + data[0] +
                                   ", Name: " + data[1] +
                                   ", Age: " + data[2] +
                                   ", Marks: " + data[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
