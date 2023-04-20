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
    public void toInteract(Entity entity) {
        attack(entity);
    }

    @Override
    public boolean availableInteractEntity() {
        return !map.getEntityByType(Herbivore.class).isEmpty();
    }

    @Override
    public void makeMove() {
        if (isCanInteract(Herbivore.class)) {
            Coordinates interactEntityCoordinates = getInteractEntityCoordinates(Herbivore.class);
            Entity entity = map.getEntity(interactEntityCoordinates);

            toInteract(entity);
        } else {
            go(map);
        }
    }

    public void attack(Entity entity){
        Herbivore herbivore = (Herbivore)entity;
        herbivore.setHp(-damage);
    }

    @Override
    public void go(Map map) {
        Entity targetEntity = (Creature)map.getEntityByType(Herbivore.class).get(0);
        Coordinates targetCoordinates = targetEntity.coordinates;
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
