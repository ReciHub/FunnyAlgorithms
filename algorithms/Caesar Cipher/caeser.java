import java.util.Scanner;

public class caeser {

    public static String encrypt(String toEncrypt, int key) {
        char[] encrypted = toEncrypt.toCharArray();
        for (char c : encrypted) {
            if (Character.isLowerCase(c)) {
                if (c >= 'z' - (key - 1) % 26) {
                    c -= 26;
                } 
                c += key;
            }
            if (Character.isUpperCase(c)) {
                if (c >= 'Z' - (key - 1) % 26) {
                    c -= 26;
                } 
                c += key;
            }
        }
        return new String(encrypted);
    }

    public static String decrypt(String toDecrypt, int key) {
        return encrypt(toDecrypt, 26 - key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you wish to decrypt or encrypt a string? ");
        boolean decrypt = false;
        // Type 'e' or "encrypt" for encrypt; 'd' or 'decrypt' for decrypt
        if (scanner.nextLine().toLowerCase() == "e" ||scanner.nextLine().toLowerCase() == "encrypt") {
            decrypt = false;
        } else if (scanner.nextLine().toLowerCase() == "d" || scanner.nextLine().toLowerCase() == "decrypt") {
            decrypt = true;
        } else {
            System.out.println("Invalid choice");
            scanner.close();
            return;
        }
        System.out.println("Which string would you like to " + (decrypt ? "decrypt" : "encrypt") + "?");
        String toMod = scanner.nextLine(); 
        System.out.println("What key would you like?");
        int key = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Your " + (decrypt ? "decrypted" : "encrypted") + " text is: ");
        if (decrypt) {
            System.out.println(decrypt(toMod, key));
        } else {
            System.out.println(encrypt(toMod, key));
        }
        scanner.close();
    }
}