package Entity.Factory;

import Entity.Creatures.Herbivores.Deer;
import Entity.Entity;
import Map.Coordinates;

public class DeerFactory implements EntityFactory {
    @Override
    public Entity create() {
        return  new Deer(15, 8, new Coordinates(1, 1),  15);
    }
}
