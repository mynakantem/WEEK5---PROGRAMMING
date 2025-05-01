package CSVExample;

import java.io.*;
import java.util.*;

class StudentDetails {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public StudentDetails(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<Integer, String[]> map1 = new HashMap<>();
        Map<Integer, String[]> map2 = new HashMap<>();

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            br1.readLine(); 
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                map1.put(id, new String[]{name, String.valueOf(age)});
            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            br2.readLine(); // Skip header
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                int marks = Integer.parseInt(data[1].trim());
                String grade = data[2].trim();
                map2.put(id, new String[]{String.valueOf(marks), grade});
            }
            br2.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            bw.write("ID,Name,Age,Marks,Grade\n");

            for (int id : map1.keySet()) {
                if (map2.containsKey(id)) {
                    String[] info1 = map1.get(id);
                    String[] info2 = map2.get(id);
                    StudentDetails student = new StudentDetails(
                            id,
                            info1[0],
                            Integer.parseInt(info1[1]),
                            Integer.parseInt(info2[0]),
                            info2[1]
                    );
                    bw.write(student.toString() + "\n");
                }
            }

            bw.close();
            System.out.println("Merged CSV created successfully as " + outputFile);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
