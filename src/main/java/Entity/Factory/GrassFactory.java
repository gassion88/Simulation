package Entity.Factory;

import Entity.Entity;
import Entity.Inanimates.Grass;
import Map.*;
import resources.Sprites;

public class GrassFactory implements EntityFactory {
    @Override
    public Entity create(Map map) {
        return new Grass(new Coordinates(1, 1),  Sprites.grass, map, 5);
    }
}
