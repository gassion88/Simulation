package Entity.Factory;

import Entity.Entity;
import Entity.Inanimates.Grass;
import Map.Coordinates;
import resources.Sprites;

public class GrassFactory implements EntityFactory {
    @Override
    public Entity create() {
        return new Grass(new Coordinates(1, 1), 5, Sprites.grass);
    }
}
