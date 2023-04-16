package Entity.Creatures.Herbivores;

import Entity.Creatures.Creature;
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

                    if (interactEntity instanceof IEatable) {
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

            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {continue;}
                verifiableCoordinates = new Coordinates(coordinates.x + x, coordinates.y + y);

                if (!map.isSquareEmpty(verifiableCoordinates)) {
                    Entity interactEntity = map.getEntity(verifiableCoordinates);

                    if (interactEntity instanceof IEatable) {
                        return verifiableCoordinates;
                    }
                }
            }
        }

        return verifiableCoordinates;
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
