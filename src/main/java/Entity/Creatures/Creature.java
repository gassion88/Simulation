package Entity.Creatures;

import Entity.Entity;
import Map.*;
import service.Node;

import java.util.List;

import static service.PathFinder.getPath;

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
    public abstract  void  toInteract();

    public boolean isCanInteract(Class<?> entityClass){
        return getInteractEntityCoordinates(entityClass) != null;
    }

    public abstract boolean availableInteractEntity();

    public Coordinates getInteractEntityCoordinates(Class<?> classType) {
        Coordinates verifiableCoordinates = null;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {continue;}

                verifiableCoordinates = new Coordinates(coordinates.x + x, coordinates.y + y);

                if (!map.isSquareEmpty(verifiableCoordinates)) {
                    Entity interactEntity = map.getEntity(verifiableCoordinates);

                    if (classType.isAssignableFrom(interactEntity.getClass()) ) {
                        return verifiableCoordinates;
                    }
                }
            }
        }

        verifiableCoordinates = null;
        return verifiableCoordinates;
    }

    public void go(Class<?> entityClass) {
        List<Entity> targets = map.getEntityByType(entityClass);

        if (targets.isEmpty()) {
            return;
        }

        Entity targetEntity = targets.get(0);
        Coordinates targetCoordinates = targetEntity.coordinates;
        List<Node> path =  getPath(coordinates, targetCoordinates, map);

        for (int i = 0; i < speed; i++) {
            if (isCanInteract(entityClass)) {
                Coordinates interactEntityCoordinates = getInteractEntityCoordinates(entityClass);
                Entity entity = map.getEntity(interactEntityCoordinates);

                toInteract();
                break;
            } else {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                map.moveEntity(coordinates, path.get(i).getCoordinates());
                new MapConsoleRenderer().render(map);
            }
        }
    }

    public void setHp( int hpAmount) {
        if ((hpAmount + hp) >= maxHp) {
            hp = maxHp;
        } else if ((hp + hpAmount) <= 0 ) {
            hp = 0;
            map.removeEntity(coordinates);
        } else {
            hp += hpAmount;
        }
    }
}
