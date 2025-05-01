package Annotations;

import java.util.ArrayList;
import java.util.List;

public class UncheckedExample {

    @SuppressWarnings("unchecked")
    public void addElements() {
        List list = new ArrayList(); // Raw type used, normally shows warning

        list.add("Apple");
        list.add("Banana");

        // This would normally cause a warning because the list is not type-safe
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
