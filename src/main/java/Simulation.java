import Actions.InitActions.InitAction;
import Actions.TurnActions.TurnAction;
import Entity.Creatures.Herbivores.Herbivore;
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
    }

    private boolean isSimulationEnd() {
        if (map.getEntityByType(Herbivore.class).isEmpty()) return true;
        if (map.getEntityByType(IEatable.class).isEmpty()) return true;

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
