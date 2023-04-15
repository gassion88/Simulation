package Map;

import Entity.Entity;

import java.util.HashMap;

public class Map {
    public final int height;
    public final int weight;
    private HashMap<Coordinates, Entity> entity = new HashMap<>();

    public Map(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        this.entity.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return this.entity.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entity.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates square) {
        return !entity.containsKey(square);
    }
}
