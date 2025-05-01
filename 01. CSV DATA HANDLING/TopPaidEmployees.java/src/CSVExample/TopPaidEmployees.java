package CSVExample;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String email;
    double salary;

    Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | " + email + " | " + salary;
    }
}

public class TopPaidEmployees {
    public static void main(String[] args) {
        String csvFile = "employees.csv"; 
        String line;
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String name = data[0].trim();
                    String email = data[1].trim();
                    double salary = Double.parseDouble(data[2].trim());
                    employees.add(new Employee(name, email, salary));
                }
            }

            List<Employee> top5 = employees.stream()
                    .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                    .limit(5)
                    .collect(Collectors.toList());

            System.out.println("Top 5 Highest Paid Employees:");
            top5.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing salary: " + e.getMessage());
        }
    }
}
