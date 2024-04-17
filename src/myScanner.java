import java.util.Scanner;

public class myScanner {
    private final Scanner scanner;

    public myScanner() {
        this.scanner = new Scanner(System.in);
    }

    public int askForNumberOfVectors() {
        System.out.println("\nEnter the number of vectors: ");
        int numberOfVectors = scanner.nextInt();
        scanner.nextLine();
        return numberOfVectors;
    }

    public String askForVectorInput() {
        System.out.println("\nEnter a vector (space-separated integers): ");
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        scanner.close();
    }
}
