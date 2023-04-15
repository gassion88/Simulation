package Entity.Creatures.Predators;

import Map.Coordinates;

public class Wolf extends Predator{
    public Wolf(int hp, int speed, Coordinates coordinates, int damage, int maxHp, String sprite) {
        super(hp, speed, coordinates, damage, maxHp, sprite);
    }

    @Override
    public void makeMove() {

    }
}