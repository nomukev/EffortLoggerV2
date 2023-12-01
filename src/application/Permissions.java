
// Import necessary classes
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// Define the Permission class
class Permission {
    private String name;

    // Constructor for the Permission class
    public Permission(String name) {
        this.name = name;
    }

    // Getter for the name of the permission
    public String getName() {
        return name;
    }
}

// Define the User class
class User {
    private String username;
    private Set<Permission> permissions;

    // Constructor for the User class
    public User(String username) {
        this.username = username;
        this.permissions = new HashSet<>();
    }

    // Method to add a permission to a user
    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    // Method to remove a permission from a user
    public void removePermission(Permission permission) {
        permissions.remove(permission);
    }

    // Method to check if a user has a certain permission
    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    // Getter for the permissions of a user
    public Set<Permission> getPermissions() {
        return permissions;
    }

    // Getter for the username of a user
    public String getUsername() {
        return username;
    }
}

class PermissionManagement {
    public static void main(String[] args) {
        // Create maps to store users and permissions
        Map<String, User> users = new HashMap<>();
        Map<String, Permission> permissions = new HashMap<>();

        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Main loop of the program
        while (true) {
            // Print menu and read command
            System.out.println("Enter a number for the command you want to execute:");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Create Permission");
            System.out.println("4. Add Permission to User");
            System.out.println("5. Remove Permission from User");
            System.out.println("6. List Users and their Permissions");
            System.out.println("7. Exit");

            // Check if the next input is an integer
            if (!scanner.hasNextInt()) {
                // If not, print an error message and continue to the next iteration of the loop
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine();
                continue;
            }

            // Read the command as an integer
            int command = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            // Exit the program if the command is 7
            if (command == 7) {
                System.out.println("Exiting...");
                break;
            } else if (command == 1) { // Add a user if the command is 1
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                users.put(username, new User(username));
                System.out.println("User " + username + " added.");
            } else if (command == 2) { // Remove a user if the command is 2
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                users.remove(username);
                System.out.println("User " + username + " removed.");
            } else if (command == 3) { // Create a permission if the command is 3
                System.out.println("Enter permission:");
                String permissionName = scanner.nextLine();
                permissions.put(permissionName, new Permission(permissionName));
                System.out.println("Permission " + permissionName + " created.");
            } else if (command == 4 || command == 5) { // Add or remove a permission from a user if the command is 4 or
                                                       // 5
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter permission:");
                String permissionName = scanner.nextLine();

                User user = users.get(username);
                Permission permission = permissions.get(permissionName);

                // Check if the user and permission exist
                if (user != null && permission != null) {
                    if (command == 4) { // Add the permission to the user if the command is 4
                        user.addPermission(permission);
                        System.out.println(user.getUsername() + " now has permission to " + permission.getName() + ".");
                    } else if (command == 5) { // Remove the permission from the user if the command is 5
                        user.removePermission(permission);
                        System.out.println(
                                user.getUsername() + " no longer has permission to " + permission.getName() + ".");
                    }
                } else { // Print an error message if the user or permission doesn't exist
                    System.out.println("User or permission not found.");
                }
            } else if (command == 6) { // List all users and their permissions if the command is 6
                for (User user : users.values()) {
                    System.out.println(user.getUsername() + "'s permissions:");
                    for (Permission permission : user.getPermissions()) {
                        System.out.println("- " + permission.getName());
                    }
                    System.out.println();
                }
            } else { // Print an error message for any other command
                System.out.println("Invalid command. Please enter a number between 1 and 7.");
            }
        }

        // Close the Scanner object when done
        scanner.close();
    }
}
