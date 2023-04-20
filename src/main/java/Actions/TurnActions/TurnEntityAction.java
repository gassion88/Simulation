package Actions.TurnActions;

import Entity.Creatures.Creature;
import Entity.Entity;
import Map.*;

import java.util.List;

public class TurnEntityAction extends TurnAction{
    Map map;
    public TurnEntityAction(Map map) {
        this.map = map;
    }

    @Override
    public void turn() {
        turnEntities(map);
    }

    private void turnEntities(Map map) {
        List<?> entities = map.getEntityByType(Creature.class);

        for (Object entity : entities) {
            Creature creature = (Creature) entity;

            new MapConsoleRenderer().render(map);
            creature.makeMove();
            new MapConsoleRenderer().render(map);
        }
    }


}
