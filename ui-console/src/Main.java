import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SEmuEngineImpl engine = new SEmuEngineImpl(); // מופע של המנוע
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int choice;

        //TODO
        //for debugging 2. show program
        engine.load_program();


        while (!exit) {
            System.out.println("1. Load file");
            System.out.println("2. Show program");
            System.out.println("3. Expand");
            System.out.println("4. Run program");
            System.out.println("5. Show history/statistics");
            System.out.println("6. Exit system");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    if (engine.isProgramLoaded()) {
                        System.out.println(engine.get_program_details());
                    } else {
                        System.out.println("No loaded program.");
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice, Please enter number between 1 and 6.\n");
            }
        }
        scanner.close();
    }
}