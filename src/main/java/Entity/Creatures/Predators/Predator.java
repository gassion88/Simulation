package Entity.Creatures.Predators;

import Entity.Creatures.Creature;
import Entity.Creatures.Herbivores.Herbivore;
import Entity.Inanimates.IEatable;
import service.Node;
import Entity.Entity;
import Map.*;

import java.util.List;

import static service.PathFinder.getPath;

public abstract class Predator extends Creature {
    public int damage;

    public Predator(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed, int damage) {
        super(coordinates, sprite, map, maxHp, hp, speed);
        this.damage = damage;
    }

    @Override
    public void toInteract() {
        attack();
    }

    @Override
    public boolean availableInteractEntity() {
        return !map.getEntityByType(Herbivore.class).isEmpty();
    }

    @Override
    public void makeMove() {
        if (isCanInteract(Herbivore.class)) {
            toInteract();
        } else {
            go(Herbivore.class);
        }
    }

    public void attack(){
        Coordinates interactEntityCoordinates = getInteractEntityCoordinates(Herbivore.class);
        Entity entity = map.getEntity(interactEntityCoordinates);

        Herbivore herbivore = (Herbivore)entity;
        herbivore.setHp(-damage);
    }
}
