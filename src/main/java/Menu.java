import java.util.Scanner;

import static resources.Strings.menuStepOne;
import static resources.Strings.menuStepTwo;

public class Menu {
    Simulation simulation;
    private static int menuStep = 1;
    private static Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void startMenu(){
        while (true) {
            String status = null;

            outputMenuByStep(menuStep);
            String userInput = inputUser();

            status = updateMenu(menuStep, userInput);

            if (status.equals("Exit")) {
                return;
            }  else if (status.equals("Generate random simulation")) {
                startRandomSimulation();
            } else if (status.equals("Configure simulation")) {
                startConfigureSimulation();
            }
        }
    }

    private void startConfigureSimulation() {
    }

    private void startRandomSimulation() {
    }

    private String updateMenu(int menuStep, String inputUser) {
        String status = "";

        if (menuStep == 1) {
            if (inputUser.equals("1")) {
                Menu.menuStep++;
                status = "StepTwo";
            } else if (inputUser.equals("2")) {
                return "Exit";
            }
        } else if (menuStep == 2 ) {
            if (inputUser.equals("1")) {
                status = "Generate random simulation";
            } else if (inputUser.equals("2")) {
                status = "Configure simulation";
            }
        }

        return status;
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
        if (menuStep == 1) {
            System.out.println(menuStepOne);
            menuStep++;
        } else if (menuStep == 2) {
            System.out.println(menuStepTwo);
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
}
