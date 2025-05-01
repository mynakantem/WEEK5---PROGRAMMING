package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class CsvToJsonCOnverter {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {
            List<String[]> allRows = reader.readAll();
            String[] headers = allRows.get(0);

            List<Map<String, String>> dataList = new ArrayList<>();
            for (int i = 1; i < allRows.size(); i++) {
                Map<String, String> data = new LinkedHashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    data.put(headers[j], allRows.get(i)[j]);
                }
                dataList.add(data);
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
