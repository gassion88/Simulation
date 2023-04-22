import Actions.InitActions.SpawnEntityAction;
import Actions.TurnActions.TurnAction;
import Actions.TurnActions.TurnEntityAction;
import Entity.Factory.DeerFactory;
import Entity.Factory.EntityFactory;
import Entity.Factory.GrassFactory;
import Entity.Factory.WolfFactory;
import Map.*;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10,10);

        HashMap<EntityFactory, Integer> entityAndHerProbabilitySpawn = new HashMap<>();
        entityAndHerProbabilitySpawn.put(new WolfFactory(), 3);
        entityAndHerProbabilitySpawn.put(new DeerFactory(), 3);
        entityAndHerProbabilitySpawn.put(new GrassFactory(), 8);
        SpawnEntityAction spawnEntityAction = new SpawnEntityAction(entityAndHerProbabilitySpawn, map);
        TurnEntityAction turnEntityAction = new TurnEntityAction(map);

        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();

        Simulation simulation = new Simulation(map, mapConsoleRenderer, List.of(spawnEntityAction), List.of(turnEntityAction));
        simulation.startSimulation();
    }
}
