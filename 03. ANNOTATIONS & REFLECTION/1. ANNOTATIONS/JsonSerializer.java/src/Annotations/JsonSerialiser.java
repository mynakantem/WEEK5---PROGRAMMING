package Annotations;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class JsonSerialiser {

    public static String toJson(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringJoiner json = new StringJoiner(", ", "{", "}");

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    json.add("\"" + key + "\": \"" + value + "\"");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return json.toString();
    }
}
