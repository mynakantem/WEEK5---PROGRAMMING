package CSVExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScores {
    public static void main(String[] args) {
        String csvFile = "student.csv"; 
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 
            System.out.println("Students with marks > 80:");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println("ID: " + data[0] + ", Name: " + data[1] +
                                       ", Age: " + data[2] + ", Marks: " + data[3]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
