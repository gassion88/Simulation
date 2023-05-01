package Entity.Factory;

import Entity.Entity;
import Entity.Inanimates.Grass;
import Map.*;
import resources.Sprites;

public class GrassFactory implements EntityFactory {
    Coordinates coordinates;
    String sprite;
    int hpAmount;

    public GrassFactory() {
        this.coordinates = new Coordinates();
        this.sprite = Sprites.grass;
        this.hpAmount = 5;
    }

    public GrassFactory(Coordinates coordinates, String sprite, int hpAmount) {
        this.coordinates = coordinates;
        this.sprite = sprite;
        this.hpAmount = hpAmount;
    }

    @Override
    public Entity create(Map map) {
        return new Grass(coordinates,  sprite, map, hpAmount);
    }

    @Override
    public String toString() {
        return "Grass{" +
                "sprite='" + sprite + '\'' +
                ", hpAmount=" + hpAmount +
                '}';
    }
}
