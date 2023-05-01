import Actions.InitActions.SpawnEntityAction;
import Actions.TurnActions.TurnEntityAction;
import Entity.Factory.*;
import Map.*;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static resources.Strings.menuStepOne;
import static resources.Strings.menuStepTwo;

public class Menu {
    Simulation simulation;
    private int menuStep = 1;
    private static final Scanner scanner = new Scanner(System.in);
    HashMap<EntityFactory, Integer> entityAndHerProbabilitySpawn = new HashMap<>();;
    Map map;
    private  final List<EntityFactory> entityFactories = List.of(new WolfFactory(), new DeerFactory(), new GrassFactory(),
            new TreeFactory(), new RockFactory());

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
        selectInAvailableEntity();

        inputMenuSize();

        startSimulation();
    }

    private void selectInAvailableEntity() {
        String userInput = inputUser();
        String[] entity = userInput.split(" ");

        for (String en : entity) {
            int entityNumber = Integer.parseInt(en.split(":")[0])-1;
            EntityFactory entityFactory = entityFactories.get(entityNumber);
            int entityProbability = Integer.parseInt(en.split(":")[1]);

            entityAndHerProbabilitySpawn.put(entityFactory, entityProbability);
        }
    }

    private void inputMenuSize() {
        System.out.println("Select menu size");

        String inputUser = inputUser();
        int height = Integer.parseInt(inputUser.split(" ")[0]);
        int weight = Integer.parseInt(inputUser.split(" ")[1]);

        map = new Map(height, weight);
    }

    private void viewAvailableEntity() {
        System.out.println("Select number entity and her amount");
        System.out.println(" ");

        for (int i = 0; i < entityFactories.size(); i++) {
            EntityFactory entityFactory = entityFactories.get(i);
            System.out.println(i+1 + ". " + entityFactory.toString());
        }
        System.out.println(" ");
    }

    private void startRandomSimulation() {
        entityAndHerProbabilitySpawn.put(new WolfFactory(), 3);
        entityAndHerProbabilitySpawn.put(new DeerFactory(), 3);
        entityAndHerProbabilitySpawn.put(new GrassFactory(), 6);
        map = new Map(10, 10);

        startSimulation();
    }

    private void startSimulation() {
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
                this.menuStep++;
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
