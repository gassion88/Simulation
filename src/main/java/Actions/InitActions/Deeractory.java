package Actions.InitActions;

import Entity.Creatures.Herbivores.Deer;
import Entity.Entity;
import Map.Coordinates;

public class Deeractory implements EntityFactory {
    @Override
    public Entity create() {
        return  new Deer(15, 8, new Coordinates(1, 1),  15);
    }
}
