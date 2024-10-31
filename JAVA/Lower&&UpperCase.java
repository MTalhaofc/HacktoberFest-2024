import java.util.Scanner;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String lowerCase = input.toLowerCase();
        System.out.println("Lowercase: " + lowerCase);

        String upperCase = input.toUpperCase();
        System.out.println("Uppercase: " + upperCase);

        scanner.close();
    }
}
