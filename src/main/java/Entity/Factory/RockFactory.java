package Entity.Factory;

import Entity.Entity;
import Entity.Inanimates.Rock;
import Map.*;
import resources.Sprites;

public class RockFactory implements EntityFactory{
    Coordinates coordinates;
    String sprite;

    public RockFactory() {
        this.coordinates = new Coordinates();
        this.sprite = Sprites.rock;
    }

    public RockFactory(Coordinates coordinates, String sprite) {
        this.coordinates = coordinates;
        this.sprite = sprite;
    }

    @Override
    public Entity create(Map map) {
        return new Rock(coordinates, sprite, map);
    }

    @Override
    public String toString() {
        return "Rock{" +
                "sprite='" + sprite + '\'' +
                '}';
    }
}
