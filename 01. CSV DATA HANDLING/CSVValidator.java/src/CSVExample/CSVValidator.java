package CSVExample;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private String email;
    private int age;

    public Student(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + email + " | " + age;
    }
}

class CSVToStudentObjects {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String email = data[2].trim();
                    int age = Integer.parseInt(data[3].trim());

                    Student student = new Student(id, name, email, age);
                    students.add(student);
                } else {
                    System.out.println("Invalid row format: " + line);
                }
            }

            System.out.println("Student List:");
            for (Student s : students) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
    }
}
