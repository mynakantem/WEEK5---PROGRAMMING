package CSVExample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class JSONCSVConverter {

    public static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
        String jsonData = new String(Files.readAllBytes(new File(jsonFile).toPath()));
        JSONArray jsonArray = new JSONArray(jsonData);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            JSONObject firstObj = jsonArray.getJSONObject(0);
            String[] headers = JSONObject.getNames(firstObj);
            writer.write(String.join(",", headers));
            writer.newLine();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                for (int j = 0; j < headers.length; j++) {
                    writer.write(String.valueOf(obj.get(headers[j])));
                    if (j < headers.length - 1) writer.write(",");
                }
                writer.newLine();
            }
        }
        System.out.println("Converted JSON to CSV: " + csvFile);
    }

    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        List<String> lines = Files.readAllLines(new File(csvFile).toPath());
        String[] headers = lines.get(0).split(",");

        JSONArray jsonArray = new JSONArray();
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            JSONObject obj = new JSONObject();
            for (int j = 0; j < headers.length; j++) {
                obj.put(headers[j], values[j]);
            }
            jsonArray.put(obj);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {
            writer.write(jsonArray.toString(2)); 
        }
        System.out.println("Converted CSV to JSON: " + jsonFile);
    }

    public static void main(String[] args) throws IOException {
        String jsonInput = "students.json";
        String csvOutput = "students.csv";
        String jsonOutput = "students_converted.json";

        jsonToCsv(jsonInput, csvOutput);
        csvToJson(csvOutput, jsonOutput);
    }
}
