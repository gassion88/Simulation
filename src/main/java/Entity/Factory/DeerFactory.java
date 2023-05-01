package Entity.Factory;

import Entity.Creatures.Herbivores.Deer;
import Entity.Entity;
import Map.Coordinates;
import Map.Map;
import resources.Sprites;

public class DeerFactory implements EntityFactory {
    Coordinates coordinates;
    String sprite;
    int maxHp;
    int hp;
    int speed;

    public DeerFactory() {
        this.coordinates = new Coordinates();
        this.sprite = Sprites.deer;
        this.maxHp = 15;
        this.hp = 15;
        this.speed = 8;
    }

    public DeerFactory(Coordinates coordinates, String sprite, int maxHp, int hp, int speed) {
        this.coordinates = coordinates;
        this.sprite = sprite;
        this.maxHp = maxHp;
        this.hp = hp;
        this.speed = speed;
    }

    @Override
    public Entity create(Map map) {
        return  new Deer( coordinates, sprite, map, maxHp, hp, speed);
    }

    @Override
    public String toString() {
        return "Deer{" +
                "sprite='" + sprite + '\'' +
                ", maxHp=" + maxHp +
                ", hp=" + hp +
                ", speed=" + speed +
                '}';
    }
}
