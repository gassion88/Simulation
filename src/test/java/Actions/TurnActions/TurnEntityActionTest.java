package Actions.TurnActions;

import Entity.Creatures.Herbivores.Deer;
import Entity.Inanimates.Grass;
import Map.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.Sprites;


import static org.junit.jupiter.api.Assertions.*;

class TurnEntityActionTest {

    static Map map;
    TurnEntityAction turnEntityAction;

    @BeforeEach
    void preparedDate() {
        map = new Map(10,10);
    }

    @Test
    void checkMovedEntity() {
        Deer deer = new Deer(new Coordinates(6, 6), Sprites.deer, map, 10, 10, 10);
        Grass grass = new Grass(new Coordinates(1, 1), Sprites.grass, map, 10);
        map.setEntity(deer.coordinates, deer);
        map.setEntity(grass.coordinates, grass);

        turnEntityAction = new TurnEntityAction(map);
        turnEntityAction.turn();

        assertEquals(deer.coordinates, grass.coordinates);
    }
}