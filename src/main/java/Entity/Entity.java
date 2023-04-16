package Entity;

import Map.Coordinates;
import Map.Map;

public abstract class Entity {
    public Coordinates coordinates;
    public String sprite;
    private Map map;
    public Entity(Coordinates coordinates, String sprite, Map map) {
        this.coordinates = coordinates;
        this.sprite = sprite;
        this.map = map;
    }
}
