
// Importing necessary Library
import java.util.HashMap;
import java.util.Scanner;

// Login System Class
public class LoginSystem {

    // HashMap to store user ID and password pairs.
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to repeatedly show the menu to the user until they decide to
        // exit
        while (true) {
            // Display menu options to the user
            System.out.println("Choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            // Handle the user's choice
            switch (choice) {
                case 1: // User chose to Login
                    // Prompt user for their ID and password
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    // Check if the provided ID and password match any registered user's credentials
                    if (users.containsKey(userId) && users.get(userId).equals(password)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Invalid User ID or Password.");
                    }
                    break;

                case 2: // User chose to Register
                    // Prompt user for their desired ID
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();

                    // Check if the provided ID is already registered
                    if (users.containsKey(userId)) {
                        System.out.println("User ID already exists. Choose a different User ID.");
                    } else {
                        // If not, prompt the user for their desired password
                        System.out.print("Enter Password: ");
                        password = scanner.nextLine();

                        // Register the new user by storing their ID and password
                        users.put(userId, password);
                        System.out.println("Registration successful!");
                    }
                    break;

                case 3: // User chose to Exit
                    System.out.println("Exiting...");
                    scanner.close(); // Close the scanner to free up resources
                    return; // Exit the program

                default: // User provided an invalid choice
                    System.out.println("Invalid option. Choose between 1, 2, and 3.");
                    break;
            }
        }
    }
}
