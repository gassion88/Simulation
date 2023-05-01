package Entity.Factory;

import Entity.Entity;
import Entity.Inanimates.Tree;
import Map.*;
import resources.Sprites;

public class TreeFactory implements EntityFactory{
    Coordinates coordinates;
    String sprite;

    public TreeFactory() {
        this.coordinates = new Coordinates();
        this.sprite = Sprites.tree;
    }

    public TreeFactory(Coordinates coordinates, String sprite) {
        this.coordinates = coordinates;
        this.sprite = sprite;
    }

    @Override
    public Entity create(Map map) {
        return new Tree(coordinates, sprite, map);
    }

    @Override
    public String toString() {
        return "TreeFactory{" +
                "sprite='" + sprite + '\'' +
                '}';
    }
}
