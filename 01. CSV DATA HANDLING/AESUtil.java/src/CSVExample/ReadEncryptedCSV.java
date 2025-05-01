package CSVExample;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadEncryptedCSV {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("encrypted_employees.csv"))) {
            String line = reader.readLine(); 
            System.out.println(line);

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String id = parts[0];
                String name = parts[1];
                String dept = parts[2];
                String email = AESUtil.decrypt(parts[3]);
                String salary = AESUtil.decrypt(parts[4]);

                System.out.println(id + "," + name + "," + dept + "," + email + "," + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

