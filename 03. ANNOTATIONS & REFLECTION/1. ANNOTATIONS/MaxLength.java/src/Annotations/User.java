package Annotations;

import java.lang.reflect.Field;

public class User {
    
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateFields();
    }

    private void validateFields() {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                try {
                    Object value = field.get(this);
                    if (value instanceof String && ((String) value).length() > maxLength.value()) {
                        throw new IllegalArgumentException("Field '" + field.getName() + "' exceeds max length of " + maxLength.value());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

