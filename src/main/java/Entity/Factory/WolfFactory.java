package Entity.Factory;

import Entity.Creatures.Predators.Wolf;
import Entity.Entity;
import Map.Coordinates;
import Map.Map;
import resources.Sprites;

public class WolfFactory implements EntityFactory {
    Coordinates coordinates;
    String sprite;
    int maxHP;
    int hp;
    int speed;
    int damage;

    public WolfFactory(){
        this.coordinates = new Coordinates(1, 1);
        this.sprite = Sprites.wolf;
        this.maxHP = 10;
        this.hp = 10;
        this.speed = 6;
        this.damage = 5;
    }

    public WolfFactory(Coordinates coordinates, String sprite, int maxHP, int hp, int speed, int damage) {
        this.coordinates = coordinates;
        this.sprite = sprite;
        this.maxHP = maxHP;
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
    }

    @Override
    public Entity create(Map map) {
        return new Wolf( coordinates,  sprite, map, maxHP, hp, speed, damage);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "sprite='" + sprite +
                ", maxHP=" + maxHP +
                ", hp=" + hp +
                ", speed=" + speed +
                ", damage=" + damage +
                '}';
    }
}
