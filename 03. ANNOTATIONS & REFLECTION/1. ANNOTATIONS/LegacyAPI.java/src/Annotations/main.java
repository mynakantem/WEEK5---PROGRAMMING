package Annotations;

public class main {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // ⚠️ Warning: deprecated method
        api.newFeature(); // ✅ Use this method
    }
}
