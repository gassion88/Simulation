package Entity.Creatures.Herbivores;

import Map.Coordinates;
import Map.Map;

public class Deer extends Herbivore{
    public Deer(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed) {
        super(coordinates, sprite, map, maxHp, hp, speed);
    }

    @Override
    public void makeMove() {

    }
}