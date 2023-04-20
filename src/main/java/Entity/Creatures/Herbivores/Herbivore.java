package Entity.Creatures.Herbivores;

import Entity.Creatures.Creature;
import service.Node;
import Entity.Entity;
import Entity.Inanimates.IEatable;
import Map.*;

import java.util.List;

import static service.PathFinder.getPath;

public abstract class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed) {
        super(coordinates, sprite, map, maxHp, hp, speed);
    }

    @Override
    public void makeMove() {
        if (isCanInteract(IEatable.class)) {
            toInteract();
        } else {
            go(IEatable.class);
        }
    }

    @Override
    public void toInteract() {
        Coordinates interactEntityCoordinates = getInteractEntityCoordinates(IEatable.class);
        Entity entity = map.getEntity(interactEntityCoordinates);
        eat(entity);
    }

    @Override
    public boolean availableInteractEntity() {
        return !map.getEntityByType(IEatable.class).isEmpty();
    }

    private void eat(Entity entity) {
        IEatable eatable = (IEatable)entity;
        setHp(eatable.getHpAmount());
    }
}
