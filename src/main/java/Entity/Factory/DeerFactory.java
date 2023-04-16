package Entity.Factory;

import Entity.Creatures.Herbivores.Deer;
import Entity.Entity;
import Map.Coordinates;
import Map.Map;
import resources.Sprites;

public class DeerFactory implements EntityFactory {
    @Override
    public Entity create(Map map) {
        return  new Deer( new Coordinates(1, 1), Sprites.deer, map, 15, 15, 8);
    }
}
