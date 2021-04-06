import error.EmptyList;
import error.ListLimit;
import helper.Client;
import helper.Data;

import java.util.Arrays;

public class Main {
    private static final Client client = new Client();
    private static final Data data = new Data();

    public static void main(String[] args) {
        int choice = client.prompt();
        while (client.isRunAgain()) {
            switch (choice){
                case 1 -> inputNumber();
                case 2 -> sortAndPrint();
                case 3 -> search();
                default -> {}
            }
            choice = client.prompt();
        }
        System.exit(0);
    }

    private static void search() {
        System.out.print("Input the integer you want to search for: ");
        try {
            int input = Integer.parseInt(client.gatherInput());
            int i = data.binarySearch(input);
            if (i != -1) System.out.println("We found " + input + " at the index " + i + " in the list.");
            else System.out.println(input + " cannot be found in the list.");

        } catch (NumberFormatException exception){
            System.out.println("Error with the input.");
        } catch (EmptyList exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void sortAndPrint() {
        try {
            data.mergeSort();
            System.out.println(Arrays.toString(data.list));
        } catch (EmptyList emptyList) {
            System.out.println(emptyList.getMessage());
        }
    }

    private static void inputNumber() {
        System.out.print("Input the integer you want to add: ");
        try {
            int input = Integer.parseInt(client.gatherInput());
            data.addNumber(input);
        } catch (NumberFormatException exception){
            System.out.println("Error with the input.");
        } catch (ListLimit exception) {
            System.out.println(exception.getMessage());
        }
    }
}
