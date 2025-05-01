package Annotations;

public class SecureService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    @RoleAllowed("USER")
    public void viewDashboard() {
        System.out.println("Dashboard accessed.");
    }
}
