package Entity.Creatures.Herbivores;

import Entity.Creatures.Creature;
import Entity.Creatures.Predators.Predator;
import Entity.Entity;
import Entity.Inanimates.IEatable;
import Map.Coordinates;
import Map.Map;

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

    }
}
