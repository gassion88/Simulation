package Entity.Creatures.Predators;

import Entity.Creatures.Herbivores.Deer;
import Entity.Inanimates.Grass;
import Map.Coordinates;
import Map.*;
import resources.Sprites;

public class Wolf extends Predator{
    public Wolf(Coordinates coordinates, String sprite, Map map, int maxHp, int hp, int speed, int damage) {
        super(coordinates, sprite, map, maxHp, hp, speed, damage);
    }

    public static void main(String[] args) {
        Map map = new Map(10,10);
        map.setEntity(new Coordinates(1,1),  new Wolf( new Coordinates(1, 1), Sprites.wolf, map, 15, 10, 6, 5));
        map.setEntity(new Coordinates(4,4),  new Deer( new Coordinates(10, 10), Sprites.deer, map, 15, 10, 8));
        map.setEntity(new Coordinates(10,9),  new Grass( new Coordinates(10, 10), Sprites.grass, map, 7));
        map.setEntity(new Coordinates(9,9),  new Grass( new Coordinates(10, 10), Sprites.grass, map, 7));
        map.setEntity(new Coordinates(8,9),  new Grass( new Coordinates(10, 10), Sprites.grass, map, 7));
        map.setEntity(new Coordinates(7,9),  new Grass( new Coordinates(10, 10), Sprites.grass, map, 7));
        map.setEntity(new Coordinates(6,9),  new Grass( new Coordinates(10, 10), Sprites.grass, map, 7));
        map.setEntity(new Coordinates(5,9),  new Grass( new Coordinates(10, 10), Sprites.grass, map, 7));

        new MapConsoleRenderer().render(map);

        Wolf wolf = (Wolf) map.getEntity(new Coordinates(1,1));
        wolf.makeMove();

        new MapConsoleRenderer().render(map);
    }
}