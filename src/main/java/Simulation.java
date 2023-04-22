import Actions.InitActions.InitAction;
import Actions.TurnActions.TurnAction;
import Entity.Creatures.Creature;
import Entity.Creatures.Herbivores.Herbivore;
import Entity.Entity;
import Entity.Inanimates.IEatable;
import Map.*;

import java.util.List;

public class Simulation {
    private Map map;
    private MapConsoleRenderer renderer;
    private List<InitAction> initActions;
    private List<TurnAction> turnActions;
    private int frameCounter;

    public Simulation(Map map, MapConsoleRenderer renderer, List<InitAction> initActions, List<TurnAction> turnActions) {
        this.map = map;
        this.renderer = renderer;
        this.initActions = initActions;
        this.turnActions = turnActions;
    }

    public void nextTurn() {
        turnActions();
        frameCounter++;
    }

    public void startSimulation() {
        init();

        while (!isSimulationEnd()) {
            nextTurn();
        }

        System.out.println("End simulation");
    }

    private boolean isSimulationEnd() {
        for (Object entityObject : map.getEntityByType(Creature.class)) {
            Creature creature = (Creature) entityObject;

            if (!creature.availableInteractEntity()) {
                return true;
            }
        }

        return false;
    }

    public void pauseSimulation() {

    }

    private void init() {
        for (InitAction initAction : initActions) {
            initAction.init();
        }
    }

    private void turnActions() {
        for (TurnAction turnAction : turnActions) {
            turnAction.turn();
        }
    }


}
