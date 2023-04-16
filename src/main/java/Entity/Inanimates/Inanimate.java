package Entity.Inanimates;

import Entity.Entity;
import Map.Coordinates;
import Map.Map;

public abstract class Inanimate extends Entity {
    public Inanimate(Coordinates coordinates, String sprite, Map map) {
        super(coordinates, sprite, map);
    }
}
