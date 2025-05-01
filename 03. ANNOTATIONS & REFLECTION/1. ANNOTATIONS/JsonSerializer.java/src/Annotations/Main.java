package Annotations;

public class Main {
    public static void main(String[] args) {
        User user = new User("john_doe", "john@example.com", 30);
        String jsonOutput = JsonSerialiser.toJson(user);
        System.out.println(jsonOutput);
    }
}

