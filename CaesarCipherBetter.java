import java.util.Scanner;

public class CaesarCipherBetter {

    public static String caesarCipher(String text, int shift, boolean isEncrypt) {
        StringBuilder result = new StringBuilder();

        if (!isEncrypt) {
            shift = 26 - (shift % 26); 
        }

        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c); 
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Caesar Cipher Program ===");

        while (true) {
            System.out.print("\nEnter your message: ");
            String message = sc.nextLine();

            System.out.print("Enter shift value: ");
            int shift = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Type 'encrypt' or 'decrypt': ");
            String choice = sc.nextLine().toLowerCase();

            String result;
            if (choice.equals("encrypt")) {
                result = caesarCipher(message, shift, true);
                System.out.println("🔒 Encrypted Message: " + result);
            } else if (choice.equals("decrypt")) {
                result = caesarCipher(message, shift, false);
                System.out.println("🔑 Decrypted Message: " + result);
            } else {
                System.out.println("❌ Invalid choice!");
            }

            System.out.print("\nDo you want to try again? (yes/no): ");
            String again = sc.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Exiting... Goodbye!");
                break;
            }
        }

        sc.close();
    }
}
