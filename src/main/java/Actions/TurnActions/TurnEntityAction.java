package Actions.TurnActions;

import Entity.Creatures.Creature;
import Entity.Entity;
import Map.*;

import java.util.ArrayList;

public class TurnEntityAction extends TurnAction {
    private final Map map;
    public TurnEntityAction(Map map) {
        this.map = map;
    }

    @Override
    public void turn() {
        turnEntities(map);
    }

    private void turnEntities(Map map)  {
        ArrayList<Entity> entities = new ArrayList<>(map.getEntityByType(Creature.class));


        for (Entity entity : entities) {
            if (!map.getEntityByType(Creature.class).contains(entity)) {
                continue;
            }

            Creature creature = (Creature) entity;
            new MapConsoleRenderer().render(map);
            creature.makeMove();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new MapConsoleRenderer().render(map);
        }
    }
}
