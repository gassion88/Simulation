package Actions.InitActions;

import Entity.Entity;
import Entity.Inanimates.Grass;
import Map.Coordinates;

public class GrassFactory implements EntityFactory{
    @Override
    public Entity create() {
        return new Grass(new Coordinates(1, 1), 5);
    }
}
