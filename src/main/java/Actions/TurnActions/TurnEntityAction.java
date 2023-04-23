package Actions.TurnActions;

import Entity.Creatures.Creature;
import Entity.Entity;
import Map.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TurnEntityAction extends TurnAction {
    Map map;
    public TurnEntityAction(Map map) {
        this.map = map;
    }

    @Override
    public void turn() {
        turnEntities(map);
    }

    private void turnEntities(Map map)  {
        ArrayList<Entity> entities = new ArrayList<>(map.getEntityByType(Creature.class));


        for (Object entity : entities) {
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
