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
}