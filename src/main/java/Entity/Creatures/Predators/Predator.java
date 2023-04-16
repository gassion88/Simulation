package Entity.Creatures.Predators;

import Entity.Creatures.Creature;
import Entity.Creatures.Herbivores.Herbivore;
import Entity.Entity;
import Entity.Inanimates.IEatable;
import Map.*;

public abstract class Predator extends Creature {
    public int damage;

    public Predator(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed, int damage) {
        super(coordinates, sprite, map, maxHp, hp, speed);
        this.damage = damage;
    }

    @Override
    public void toInteract(Entity entity) {
        attack(entity);
    }

    @Override
    public void makeMove() {
        if (isCanInteract()) {
            Coordinates interactEntityCoordinates = getInteractEntityCoordinates();
            Entity entity = map.getEntity(interactEntityCoordinates);

            toInteract(entity);
        } else {
            go(map);
        }
    }

    @Override
    public boolean isCanInteract() {
        for (int x = -1; x <= 1; x++) {

            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {continue;}
                Coordinates verifiableCoordinates = new Coordinates(coordinates.x + x, coordinates.y + y);

                if (!map.isSquareEmpty(verifiableCoordinates)) {
                    Entity interactEntity = map.getEntity(verifiableCoordinates);

                    if (interactEntity instanceof Herbivore) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Coordinates getInteractEntityCoordinates() {
        Coordinates verifiableCoordinates = new Coordinates(0, 0);

        for (int x = -1; x <= 1; x++) {
            if (x == 0) {continue;}

            for (int y = -1; y <= 1; y++) {
                if (y == 0) {continue;}
                verifiableCoordinates = new Coordinates(coordinates.x + x, coordinates.y + y);

                if (!map.isSquareEmpty(verifiableCoordinates)) {
                    Entity interactEntity = map.getEntity(verifiableCoordinates);

                    if (interactEntity instanceof Herbivore) {
                        return verifiableCoordinates;
                    }
                }
            }
        }

        return verifiableCoordinates;
    }

    public void attack(Entity entity){
        Herbivore herbivore = (Herbivore)entity;
        herbivore.setHp(-damage);
    }

    @Override
    public void go(Map map) {

    }
}
