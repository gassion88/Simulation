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
    public void toInteract(Entity entity) {
        eat(entity);
    }

    private void eat(Entity entity) {
        IEatable eatable = (IEatable)entity;
        setHp(eatable.getHpAmount());
    }
}
