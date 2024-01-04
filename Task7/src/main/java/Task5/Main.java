package Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose operation:");
        System.out.println("1. Encryption");
        System.out.println("2. Decryption");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter text: ");
        String inputText = scanner.nextLine();

        System.out.print("Enter key (32 characters): ");
        String key = scanner.nextLine();

        try {
            if (choice == 1) {
                String encryptedText = AES256.encrypt(inputText, key);
                System.out.println("Encrypted text: " + encryptedText);
            } else if (choice == 2) {
                String decryptedText = AES256.decrypt(inputText, key);
                System.out.println("Decrypted text: " + decryptedText);
            } else {
                System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
