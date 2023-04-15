package Entity;

import Map.Coordinates;

public abstract class Entity {
    public Coordinates coordinates;
    public String sprite;

    public Entity(Coordinates coordinates, String sprite) {
        this.coordinates = coordinates;
        this.sprite = sprite;
    }
}
