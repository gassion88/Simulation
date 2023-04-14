package Entity.Creatures.Predators;

import Map.Coordinates;

public class Wolf extends Predator{
    public Wolf(int hp, int speed, Coordinates coordinates, int damage, int maxHp) {
        super(hp, speed, coordinates, damage, maxHp);
    }

    @Override
    public void makeMove() {

    }
}
