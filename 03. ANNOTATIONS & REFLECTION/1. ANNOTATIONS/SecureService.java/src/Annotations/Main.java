package Annotations;

import java.lang.reflect.Method;

public class Main {

    static String currentUserRole = "USER"; 

    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();

        Method[] methods = SecureService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAllowed.value();

                System.out.println("Attempting to access: " + method.getName());

                if (currentUserRole.equals(requiredRole)) {
                    method.invoke(service);
                } else {
                    System.out.println("🚫 Access Denied! Required Role: " + requiredRole);
                }
                System.out.println();
            }
        }
    }
}
