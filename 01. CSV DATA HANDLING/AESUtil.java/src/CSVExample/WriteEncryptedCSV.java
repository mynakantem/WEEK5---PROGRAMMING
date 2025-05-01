package CSVExample;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteEncryptedCSV {

    public static void main(String[] args) {
        String[][] employees = {
            {"101", "Ananya Sharma", "HR", "ananya@example.com", "60000"},
            {"102", "Ravi Kumar", "IT", "ravi@example.com", "75000"}
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_employees.csv"))) {
            writer.write("ID,Name,Department,Email,Salary");
            writer.newLine();

            for (String[] emp : employees) {
                String encryptedEmail = AESUtil.encrypt(emp[3]);
                String encryptedSalary = AESUtil.encrypt(emp[4]);
                writer.write(emp[0] + "," + emp[1] + "," + emp[2] + "," + encryptedEmail + "," + encryptedSalary);
                writer.newLine();
            }

            System.out.println("Encrypted CSV written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
