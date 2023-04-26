import java.util.Scanner;

public class Menu {
    Simulation simulation;
    static Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public static void startMenu(){
        int menuStep = 1;

        while (true) {
            outputMenuByStep(menuStep);
            String userInput = inputUser();

            if (userInput.equals("1")) {
                System.out.println("Start");
            } else if (userInput.equals("2")) {
                return;
            }
        }
    }

    private static String inputUser() {
        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.length() == 0) {
                continue;
            }

            return userInput;
        }
    }

    private static void outputMenuByStep(int menuStep) {
        System.out.println("""
                1.Сгенерировать симуляцию.
                2.Выйти
                """);
    }

    public static void main(String[] args) {
        startMenu();
    }
}
