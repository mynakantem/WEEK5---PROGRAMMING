package JSONExample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.*;

import java.io.*;
import java.util.*;

public class IPLCensorAnalyser {

    public static void main(String[] args) throws Exception {
        processJSON("input/ipl_data.json", "output/ipl_data_censored.json");
        processCSV("input/ipl_data.csv", "output/ipl_data_censored.csv");
        System.out.println("Censorship complete. Files saved in output/ folder.");
    }

    public static void processJSON(String inputPath, String outputPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> matches = mapper.readValue(new File(inputPath), new TypeReference<>() {});

        for (Map<String, Object> match : matches) {
            match.put("team1", maskTeam((String) match.get("team1")));
            match.put("team2", maskTeam((String) match.get("team2")));
            match.put("winner", maskTeam((String) match.get("winner")));
            match.put("player_of_match", "REDACTED");

            Map<String, Object> originalScore = (Map<String, Object>) match.get("score");
            Map<String, Object> newScore = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : originalScore.entrySet()) {
                newScore.put(maskTeam(entry.getKey()), entry.getValue());
            }
            match.put("score", newScore);
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), matches);
    }

    public static void processCSV(String inputPath, String outputPath) throws IOException {
        try (
            CSVReader reader = new CSVReader(new FileReader(inputPath));
            CSVWriter writer = new CSVWriter(new FileWriter(outputPath))
        ) {
            List<String[]> allRows = reader.readAll();
            writer.writeNext(allRows.get(0)); // header

            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                row[1] = maskTeam(row[1]); // team1
                row[2] = maskTeam(row[2]); // team2
                row[5] = maskTeam(row[5]); // winner
                row[6] = "REDACTED";       // player_of_match
                writer.writeNext(row);
            }
        }
    }

    private static String maskTeam(String teamName) {
        int spaceIndex = teamName.indexOf(" ");
        return (spaceIndex != -1) ? teamName.substring(0, spaceIndex) + " ***" : teamName;
    }
}
