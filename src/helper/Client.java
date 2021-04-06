package helper;

import java.util.Scanner;

public class Client {
    final Scanner scanner = new Scanner(System.in);

    private int answer = 0;

    public String gatherInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public boolean isRunAgain() {
        return !(answer == 0);
    }

    public int prompt() {
        System.out.println("""
                > 0. Exit
                > 1. Input Integer
                > 2. Sort and Print (Merge Sort)
                > 3. Binary Search
                """);
        System.out.print("Which one would you like to select? (0-3): ");

        answer = scanner.nextInt();
        if (answer > 3 || answer < 0) {
            answer = 4;
            System.out.println("Invalid, choose again.");
        }
        System.out.println();
        scanner.nextLine();
        return answer;
    }
}