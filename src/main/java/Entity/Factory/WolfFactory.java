package Entity.Factory;

import Entity.Creatures.Predators.Wolf;
import Entity.Entity;
import Map.Coordinates;
import Map.Map;
import resources.Sprites;

public class WolfFactory implements EntityFactory {
    @Override
    public Entity create(Map map) {
        return new Wolf( new Coordinates(1, 1),  Sprites.wolf, map, 10, 10, 6, 5);
    }
}
