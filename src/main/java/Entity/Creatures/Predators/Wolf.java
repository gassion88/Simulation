package Entity.Creatures.Predators;

import Map.Coordinates;
import Map.*;

public class Wolf extends Predator{
    public Wolf(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed, int damage) {
        super(coordinates, sprite, map, maxHp, hp, speed, damage);
    }
}