package Entity.Creatures.Predators;

import Entity.Creatures.Creature;
import Entity.Creatures.Herbivores.Herbivore;
import Entity.Creatures.service.AStarAlgorithm;
import Entity.Creatures.service.Node;
import Entity.Entity;
import Entity.Inanimates.IEatable;
import Map.*;

import java.nio.file.Path;
import java.util.List;

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
        Coordinates targetCoordinates = map.getEntityByType(Herbivore.class).get(0).coordinates;
        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm(coordinates, targetCoordinates, map);

        List<Node> path = aStarAlgorithm.getPath();

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
