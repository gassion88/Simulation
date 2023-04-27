import Actions.InitActions.SpawnEntityAction;
import Actions.TurnActions.TurnEntityAction;
import Entity.Factory.DeerFactory;
import Entity.Factory.EntityFactory;
import Entity.Factory.GrassFactory;
import Entity.Factory.WolfFactory;
import Map.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static resources.Strings.menuStepOne;
import static resources.Strings.menuStepTwo;

public class Menu {
    Simulation simulation;
    private static int menuStep = 1;
    private static Scanner scanner = new Scanner(System.in);
    HashMap<EntityFactory, Integer> entityAndHerProbabilitySpawn;

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
        viewAvailableEntity();
    }

    private void viewAvailableEntity() {
        List<EntityFactory> entityFactories = new ArrayList<>();
        entityFactories.add(new DeerFactory());
        entityFactories.add(new WolfFactory());
        entityFactories.add(new GrassFactory());

        System.out.println("Select entities");
        System.out.println(" ");
        for (EntityFactory entityFactory : entityFactories) {
            System.out.println(entityFactory.toString());
        }
    }

    private void startRandomSimulation() {
        Map map = new Map(10,10);

        entityAndHerProbabilitySpawn = new HashMap<>();
        entityAndHerProbabilitySpawn.put(new WolfFactory(), 3);
        entityAndHerProbabilitySpawn.put(new DeerFactory(), 3);
        entityAndHerProbabilitySpawn.put(new GrassFactory(), 6);
        SpawnEntityAction spawnEntityAction = new SpawnEntityAction(entityAndHerProbabilitySpawn, map);
        TurnEntityAction turnEntityAction = new TurnEntityAction(map);

        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();

        simulation = new Simulation(map, mapConsoleRenderer, List.of(spawnEntityAction), List.of(turnEntityAction));
        simulation.startSimulation();
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
            } else if (inputUser.equals("3")) {
                status = "Exit";
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
