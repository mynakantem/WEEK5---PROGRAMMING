package Annotations;

public class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Do not use this anymore.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}
