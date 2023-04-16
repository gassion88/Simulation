package Entity.Creatures;

import Entity.Creatures.Herbivores.Herbivore;
import Entity.Entity;
import Map.*;

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

    public boolean isCanInteract(Map map, Class<? extends Entity> ccc){
        for (int x = -1; x <= 1; x++) {
            if (x == 0) {continue;}

            for (int y = -1; y <= 1; y++) {
                if (y == 0) {continue;}
                Coordinates verifiableCoordinates = new Coordinates(coordinates.x + x, coordinates.y + y);

                if (!map.isSquareEmpty(verifiableCoordinates)) {
                    Entity interactEntity = map.getEntity(verifiableCoordinates);

                    if (interactEntity.getClass() == ccc ) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    //public abstract void go(Map map);

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
