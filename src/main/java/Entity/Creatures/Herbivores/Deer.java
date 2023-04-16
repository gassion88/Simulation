package Entity.Creatures.Herbivores;

import Actions.InitActions.SpawnEntityAction;
import Entity.Factory.DeerFactory;
import Entity.Factory.EntityFactory;
import Entity.Factory.GrassFactory;
import Entity.Factory.WolfFactory;
import Entity.Inanimates.Grass;
import Map.Coordinates;
import Map.*;
import resources.Sprites;
import java.util.HashMap;
import Entity.Entity;

public class Deer extends Herbivore{
    public Deer(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed) {
        super(coordinates, sprite, map, maxHp, hp, speed);
    }

    public static void main(String[] args) {
        Map map = new Map(10,10);
        map.setEntity(new Coordinates(1,1),  new Deer( new Coordinates(1, 1), Sprites.deer, map, 15, 10, 8));
        map.setEntity(new Coordinates(1,2),  new Grass(new Coordinates(1, 2),  Sprites.grass, map, 5));

        new MapConsoleRenderer().render(map);

        Deer deer = (Deer) map.getEntity(new Coordinates(1,1));
        deer.makeMove();

        new MapConsoleRenderer().render(map);


    }
}