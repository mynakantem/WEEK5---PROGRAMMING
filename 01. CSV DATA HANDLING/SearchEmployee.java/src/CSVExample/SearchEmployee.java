package CSVExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String line;
        boolean found = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1].trim().toLowerCase();

                if (name.equals(searchName)) {
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

