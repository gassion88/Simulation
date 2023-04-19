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
            Coordinates interactEntityCoordinates = getInteractEntityCoordinates(IEatable.class);
            Entity entity = map.getEntity(interactEntityCoordinates);

            toInteract(entity);
        } else {
            System.out.println("Not interact Entity");
        }
    }

    @Override
    public void toInteract(Entity entity) {
        eat(entity);
    }

    private void eat(Entity entity) {
        IEatable eatable = (IEatable)entity;
        setHp(eatable.getHpAmount());

        map.removeEntity(entity.coordinates);
    }

    @Override
    public void go(Map map) {
        Entity targetiEatable = (Entity) map.getEntityByType(IEatable.class).get(0);
        Coordinates targetCoordinates = targetiEatable.coordinates;
        List<Node> path =  getPath(coordinates, targetCoordinates, map);

        for (int i = 0; i < speed; i++) {
            if (isCanInteract(Herbivore.class)) {
                Coordinates interactEntityCoordinates = getInteractEntityCoordinates(Herbivore.class);
                Entity entity = map.getEntity(interactEntityCoordinates);

                toInteract(entity);
                break;
            } else {
                map.moveEntity(coordinates, path.get(i).getCoordinates());
            }

            new MapConsoleRenderer().render(map);
        }
    }
}
