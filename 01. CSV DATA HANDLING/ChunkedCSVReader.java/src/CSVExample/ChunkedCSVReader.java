package CSVExample;

import java.io.*;

public class ChunkedCSVReader {
    public static void main(String[] args) {
        String csvFile = "large_data.csv";  
        int chunkSize = 100;               
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineCount = 0;

            String header = br.readLine();
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                
                lineCount++;
                totalRecords++;

                if (lineCount == chunkSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    lineCount = 0;
                    
                }
            }

            if (lineCount > 0) {
                System.out.println("Processed " + totalRecords + " records in total.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
