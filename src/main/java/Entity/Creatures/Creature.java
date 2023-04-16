package Entity.Creatures;

import Entity.Creatures.Herbivores.Herbivore;
import Entity.Entity;
import Entity.Inanimates.IEatable;
import Map.*;

import java.util.Objects;

public abstract class Creature extends Entity {
    private final int maxHp;
    public int hp;
    public final int speed;


    public Creature(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed) {
        super(coordinates, sprite, map);
        this.maxHp = maxHp;
        this.hp = hp;
        this.speed = speed;
    }

    public abstract void makeMove();
    public abstract  void  toInteract(Entity entity);

    public abstract boolean isCanInteract();

    public abstract Coordinates getInteractEntityCoordinates();
    public abstract void go(Map map);

    public void setHp( int hpAmount) {
        if ((hpAmount + hp) >= maxHp) {
            hp = maxHp;
        } else if ((hp - hpAmount) <= 0 ) {
            hp = 0;
        } else {
            hp += hpAmount;
        }
    }
}
