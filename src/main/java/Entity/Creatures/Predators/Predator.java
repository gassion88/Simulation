package Entity.Creatures.Predators;

import Entity.Creatures.Creature;
import Entity.Creatures.Herbivores.Herbivore;
import Entity.Entity;
import Map.Coordinates;

public abstract class Predator extends Creature {
    public int damage;

    public Predator(int hp, int speed, Coordinates coordinates, int damage, int maxHp, String sprite) {
        super(hp, speed, coordinates, maxHp, sprite);
        this.damage = damage;
    }

    @Override
    public void toInteract(Entity entity) {
        attack(entity);
    }

    @Override
    public boolean isInteract(Entity entity) {
        if (entity instanceof Herbivore){
            return true;
        } else {
            return false;
        }
    }

    public void attack(Entity entity){
        Herbivore herbivore = (Herbivore)entity;
        herbivore.setHp(-damage);
    }
}
