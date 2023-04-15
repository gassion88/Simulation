package Entity.Factory;

import Entity.Creatures.Predators.Wolf;
import Entity.Entity;
import Map.Coordinates;
import resources.Sprites;

public class WolfFactory implements EntityFactory {
    @Override
    public Entity create() {
        return new Wolf(10, 5, new Coordinates(1, 1), 5, 10, Sprites.wolf);
    }
}
