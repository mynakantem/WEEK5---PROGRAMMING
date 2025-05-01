package Annotations;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Alice");
            System.out.println("✅ Username accepted: " + validUser.getUsername());

            User invalidUser = new User("VeryLongUsername123");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
