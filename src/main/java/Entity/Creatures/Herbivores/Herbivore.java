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
            go(map);
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

    @Override
    public void go(Map map) {
        List<Entity> targets = map.getEntityByType(IEatable.class);
        Entity targetEatable = targets.get(0);
        Coordinates targetCoordinates = targetEatable.coordinates;
        List<Node> path =  getPath(coordinates, targetCoordinates, map);

        for (int i = 0; i < speed; i++) {
            if (isCanInteract(IEatable.class)) {
                Coordinates interactEntityCoordinates = getInteractEntityCoordinates(IEatable.class);
                Entity entity = map.getEntity(interactEntityCoordinates);

                toInteract();
                break;
            } else {
                map.moveEntity(coordinates, path.get(i).getCoordinates());
            }

            new MapConsoleRenderer().render(map);
        }
    }
}
